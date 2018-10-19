package ru.kassatka.comepay_sdk.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import java.util.ArrayList;

public class QueryBuilder<T extends Enum<T>> {
  protected String TABLE = "PRODUCT_MODEL";
  private static final String URI_STRING =
      "content://ru.kassa.service.kassa.ProductsContentProvider";
  private static final String SEND_BARCODE =
      "ru.kassa.service.kassa.ProductsDatabaseBroadcastReceiver";
  private static final String INVALID_REQUEST = "Invalid request";
  private static final String INVALID_PART = " invalid_part...";
  private static final String FROM = "FROM";

  private String querySelect;
  private String queryWhere;
  private String queryGroup;
  private String queryOrder;

  private boolean isQuerySelectCorrect = false;
  private boolean isWhereStep = false;
  private boolean isWhereFieldStep;
  private boolean isWhereValueStep;
  private boolean isWhereLogicSignStep;

  private boolean isGroupByStep;
  private boolean isGroupByValueStep;

  private boolean isOrderByStep;
  private boolean isOrderByValueStep;
  private boolean isOrderByTypeStep;
  protected QueryBuilderListener queryBuilderListener;

  public <T extends Enum<T>> void enumValues(Class<T> enumType) {
    for (T c : enumType.getEnumConstants()) {
      c.name();
    }
  }

  public QueryBuilder() {
    querySelect = QueryBuilder.SqlOperators.SELECT.operator;
    queryBuilderListener = (cursor) -> {};
  }

  public QueryBuilder(QueryBuilderListener queryBuilderListener, String table) {
    this.querySelect = QueryBuilder.SqlOperators.SELECT.operator;
    this.queryBuilderListener = queryBuilderListener;
    this.TABLE = table;
  }

  public QueryBuilder<T> withFields(ArrayList<T> checkModelFields) {
    int arraySize = checkModelFields.size();
    for (int i = 0; i < arraySize; i++) {
      this.querySelect += " " + checkModelFields.get(i);
      if (i < arraySize - 1) {
        this.querySelect += ",";
      } else {
        this.querySelect += " ";
      }
    }
    this.querySelect += FROM + " " + TABLE;
    this.isQuerySelectCorrect = true;
    return this;
  }

  public QueryBuilder<T> where() {
    activateWhereStep();
    this.queryWhere = QueryBuilder.SqlOperators.WHERE.operator;
    this.isWhereStep = true;
    return this;
  }

  public QueryBuilder<T> field(T checkModelField) {
    boolean flag = isWhereStep || isWhereLogicSignStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    activateWhereFieldStep();
    this.queryWhere += " " + checkModelField;
    return this;
  }

  private void activateWhereStep() {
    isWhereStep = true;
    isWhereFieldStep = false;
    isWhereValueStep = false;
    isWhereLogicSignStep = false;
  }

  private void activateWhereFieldStep() {
    isWhereStep = false;
    isWhereFieldStep = true;
    isWhereValueStep = false;
    isWhereLogicSignStep = false;
  }

  private void activateWhereValueStep() {
    isWhereStep = false;
    isWhereFieldStep = false;
    isWhereValueStep = true;
    isWhereLogicSignStep = false;
  }

  private void activateWhereLogicSignStep() {
    isWhereStep = false;
    isWhereFieldStep = false;
    isWhereValueStep = false;
    isWhereLogicSignStep = true;
  }

  public QueryBuilder<T> equal(String value) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.EQ.operator + " " + value;
    activateWhereValueStep();
    return this;
  }

  public QueryBuilder<T> notEqual(String value) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.NEQ.operator + " " + value;
    activateWhereValueStep();
    return this;
  }

  public QueryBuilder<T> moreEqual(String value) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.MEQ.operator + " " + value;
    activateWhereValueStep();
    return this;
  }

  public QueryBuilder<T> lessEqual(String value) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.LEQ.operator + " " + value;
    activateWhereValueStep();
    return this;
  }

  public QueryBuilder<T> less(String value) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.LESS.operator + " " + value;
    activateWhereValueStep();
    return this;
  }

  public QueryBuilder<T> more(String value) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.MORE.operator + " " + value;
    activateWhereValueStep();
    return this;
  }

  public QueryBuilder<T> and() {
    boolean flag = isWhereValueStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.AND.operator;
    activateWhereLogicSignStep();
    return this;
  }

  public QueryBuilder<T> or() {
    boolean flag = isWhereValueStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.OR.operator;
    activateWhereLogicSignStep();
    return this;
  }

  public QueryBuilder<T> like(String value) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    queryWhere += " " + QueryBuilder.SqlOperators.LIKE.operator + " " + value;
    activateWhereValueStep();
    return this;
  }

  public QueryBuilder<T> in(ArrayList<String> values) {
    boolean flag = isWhereFieldStep;
    if (!flag)
      throw new RuntimeException(INVALID_REQUEST + ": " + getInvalidQuery() + INVALID_PART);
    int valuesSize = values.size();
    queryWhere += " IN (";
    for (int i = 0; i < valuesSize; i++) {
      queryWhere += " " + values.get(i);
      if (i < valuesSize - 1) {
        queryWhere += ",";
      } else {
        queryWhere += ")";
      }
    }
    activateWhereValueStep();
    return this;
  }

  private void activateGroupByStep() {
    isGroupByStep = true;
    isGroupByValueStep = false;
  }

  private void activateGroupByValueStep() {
    isGroupByStep = false;
    isGroupByValueStep = true;
  }

  private void activateOrderByStep() {
    isOrderByStep = true;
    isOrderByValueStep = false;
    isOrderByTypeStep = false;
  }

  private void activateOrderByValueStep() {
    isOrderByStep = false;
    isOrderByValueStep = true;
    isOrderByTypeStep = false;
  }

  private void activateOrderByTypeStep() {
    isOrderByStep = false;
    isOrderByValueStep = false;
    isOrderByTypeStep = true;
  }

  public QueryBuilder<T> groupBy() {
    this.queryGroup = "GROUP BY";
    activateGroupByStep();
    return this;
  }

  public QueryBuilder<T> groupField(T checkModelField) {
    if (!(isGroupByStep || isGroupByValueStep))
      throw new RuntimeException(INVALID_REQUEST + getInvalidQuery() + INVALID_PART);
    if (isGroupByStep) this.queryGroup += " ";
    else if (isGroupByValueStep) this.queryGroup += ", ";
    this.queryGroup += checkModelField;
    activateGroupByValueStep();
    return this;
  }

  public QueryBuilder<T> orderBy() {
    this.queryOrder = "ORDER BY";
    activateOrderByStep();
    return this;
  }

  public QueryBuilder<T> orderField(T checkModelField) {
    if (!(isOrderByStep || isOrderByValueStep))
      throw new RuntimeException(INVALID_REQUEST + getInvalidQuery() + INVALID_PART);
    if (isOrderByStep) this.queryOrder += " ";
    else if (isOrderByValueStep) this.queryOrder += ", ";
    this.queryOrder += checkModelField;
    activateOrderByValueStep();
    return this;
  }

  public QueryBuilder<T> asc() {
    if (!isOrderByValueStep)
      throw new RuntimeException(INVALID_REQUEST + getInvalidQuery() + INVALID_PART);
    this.queryOrder += " ASC";
    activateOrderByTypeStep();
    return this;
  }

  public QueryBuilder<T> desc() {
    if (!isOrderByValueStep)
      throw new RuntimeException(INVALID_REQUEST + getInvalidQuery() + INVALID_PART);
    this.queryOrder += " DESC";
    activateOrderByTypeStep();
    return this;
  }

  private String getInvalidQuery() {
    return querySelect + " " + queryWhere + " " + queryGroup + " " + queryOrder;
  }

  public String getQuery() {
    String result = "";
    if (isQuerySelectCorrect) {
      result += querySelect;
    } else {
      return null;
    }
    if (isWhereValueStep) {
      result += " " + queryWhere;
    }
    if (isGroupByValueStep) {
      result += " " + queryGroup;
    }
    if (isOrderByValueStep || isOrderByTypeStep) {
      result += " " + queryOrder;
    }
    return (result + ";").replaceAll(" ALL ", " * ");
  }

  public void executeSelectQuery(Context context) {
    Cursor cursor =
        context.getContentResolver().query(Uri.parse(URI_STRING), null, null, null, getQuery());
    queryBuilderListener.displaySelectedFields(cursor);
  }

  public static void updateProductBarcode(Context context, String product, String barcode) {
    ContentValues contentValues = new ContentValues();
    contentValues.put("BARCODE", barcode);
    context
        .getContentResolver()
        .update(Uri.parse(URI_STRING), contentValues, "NAME = ?", new String[] {product});
  }

  protected enum SqlOperators {
    SELECT("SELECT"),
    WHERE("WHERE"),
    LIKE("LIKE"),
    ORDER_BY("ORDER BY"),
    GROUP_BY("GROUP BY"),
    HAVING("HAVING"),
    ASC("ASC"),
    DESC("DESC"),
    IN("IN"),
    NEQ("<>"),
    EQ("="),
    LEQ("<="),
    MEQ(">="),
    MORE(">"),
    LESS("<"),
    AND("AND"),
    OR("OR");

    private final String operator;

    SqlOperators(String operator) {
      this.operator = operator;
    }
  }

  public interface QueryBuilderListener {
    void displaySelectedFields(Cursor cursor);
  }
}
