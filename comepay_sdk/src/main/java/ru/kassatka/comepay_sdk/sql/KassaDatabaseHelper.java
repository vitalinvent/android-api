package ru.kassatka.comepay_sdk.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

public class KassaDatabaseHelper extends SQLiteOpenHelper {

  private static final String KASSA_APP = "ru.kassa";
  private static final String DB_PATH =
      Environment.getExternalStorageDirectory().getPath().toString()
          + "/Android/data/"
          + KASSA_APP
          + "/databases/";
  private static final String DB_NAME = "products.db";


  Context context;
  SQLiteDatabase sqLiteDatabase;

  public KassaDatabaseHelper(Context context) {
    super(context, DB_PATH + DB_NAME, null, 1);
    this.context = context;
    try {
      sqLiteDatabase =
          SQLiteDatabase.openDatabase(DB_PATH + DB_NAME, null, SQLiteDatabase.OPEN_READONLY);
    } catch (SQLiteException exception) {
      sqLiteDatabase = null;
      exception.printStackTrace();
    }
  }

  @Override
  public void onCreate(SQLiteDatabase sqLiteDatabase) {}

  @Override
  public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {}

  public SQLiteDatabase getSqLiteDatabase() {
    return sqLiteDatabase;
  }

  public Cursor getPositionBySelect(String select) {
    return sqLiteDatabase.rawQuery(select, null);
  }
}
