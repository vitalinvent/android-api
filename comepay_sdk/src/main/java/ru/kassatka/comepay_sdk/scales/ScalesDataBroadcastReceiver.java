package ru.kassatka.comepay_sdk.scales;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Использовать данный класс необходимо в приложении при получении события 'ru.kassa.action.cart.config.START_GET_WEIGHT".
 * После взвешивания товара, в Intent для {@link ru.kassatka.integration.sdk.scales.ScalesDataBroadcastReceiver} необходимо поместить следующие поля:
 * VENDOR_NAME – наименование производителя, которое будет отображаться при подключении устройства (String).
 * MODEL_NAME – наименование модели устройства (String).
 * PRODUCT_WEIGHT - масса продукта (long)
 */
public class ScalesDataBroadcastReceiver extends BroadcastReceiver {

  private static final String SEND_WEIGHT = "ru.kassa.action.cart.config.SEND_WEIGHT";
  private static final String GET_WEIGHT = "ru.kassa.action.cart.config.GET_WEIGHT";

  private static final String SEND_VENDOR_NAME = "ru.kassa.action.cart.config.SEND_VENDOR_NAME";
  private static final String GET_VENDOR_NAME = "ru.kassa.action.cart.config.GET_VENDOR_NAME";

  private static final String SEND_MODEL_NAME = "ru.kassa.action.cart.config.SEND_MODEL_NAME";
  private static final String GET_MODEL_NAME = "ru.kassa.action.cart.config.GET_MODEL_NAME";

  private static final String VENDOR_NAME = "VENDOR_NAME";
  private static final String MODEL_NAME = "MODEL_NAME";
  private static final String PRODUCT_WEIGHT = "PRODUCT_WEIGHT";

  @Override

  public void onReceive(Context context, Intent intent) {
    final String action = intent.getAction();
    if (action.isEmpty()) return;
    switch (action) {
      case SEND_WEIGHT:
        Intent getWeightIntent = new Intent(GET_WEIGHT);
        getWeightIntent.putExtra(PRODUCT_WEIGHT, intent.getLongExtra(PRODUCT_WEIGHT, -1L));
        context.sendBroadcast(getWeightIntent);
      case SEND_VENDOR_NAME:
        Intent getVendorNameIntent = new Intent(GET_VENDOR_NAME);
        getVendorNameIntent.putExtra(VENDOR_NAME, intent.getStringExtra(VENDOR_NAME));
        context.sendBroadcast(getVendorNameIntent);
        break;
      case SEND_MODEL_NAME:
        Intent getModelNameIntent = new Intent(GET_MODEL_NAME);
        getModelNameIntent.putExtra(MODEL_NAME, intent.getStringExtra(MODEL_NAME));
        context.sendBroadcast(getModelNameIntent);
        break;
      default:
        break;
    }
  }
}
