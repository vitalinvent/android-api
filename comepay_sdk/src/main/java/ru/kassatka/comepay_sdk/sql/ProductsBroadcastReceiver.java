package ru.kassatka.comepay_sdk.sql;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;

public class ProductsBroadcastReceiver extends BroadcastReceiver {

  public interface ProductsListener {
    void displayProductPositions(Cursor cursor);
  }

  private static final String EMPTY_SQL = "Empty SQL query exception.";
  private static final String SEND_BARCODE =
      "ru.kassa.service.kassa.ProductsDatabaseBroadcastReceiver";
  private static final String GET_PRODUCT =
      "ru.kassatka.integration.sdk.barcode.BarcodeBroadCastReceiver";
  private static final String BARCODE = "BARCODE";
  ProductsListener productsListener;
  private KassaDatabaseHelper kassaDatabaseHelper;
  private String packageName;

  public ProductsBroadcastReceiver() {
    this.productsListener = (cursor) -> {
    };
  }

  public ProductsBroadcastReceiver(ProductsListener productsListener) {
    this.productsListener = productsListener;
  }

  public void setBarcodeListener(ProductsListener productsListener) {
    this.productsListener = productsListener;
  }

  public void setPackageName(String packageName) {
    this.packageName = packageName;
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    final String action = intent.getAction();
    final String packageName = intent.getStringExtra("PACKAGE_NAME");
    if (!packageName.equals(this.packageName)) return;
    switch (action) {
      case GET_PRODUCT:
        Log.d(ProductsBroadcastReceiver.class.getName(), GET_PRODUCT);
        kassaDatabaseHelper = new KassaDatabaseHelper(context);
        String sql = intent.getStringExtra("SQL");
        if (sql == null) {
          throw new IllegalArgumentException(EMPTY_SQL);
        }
        productsListener.displayProductPositions(kassaDatabaseHelper.getPositionBySelect(sql));
        break;
      default:
        break;
    }
  }
}
