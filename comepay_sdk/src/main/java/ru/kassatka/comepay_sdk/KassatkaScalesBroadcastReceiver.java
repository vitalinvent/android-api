package ru.kassatka.comepay_sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class KassatkaScalesBroadcastReceiver extends BroadcastReceiver {
  public static final String START_GET_WEIGHT = "ru.kassa.action.cart.config.open";
  public static final String STOP_GET_WEIGHT = "ru.kassa.action.cart.config.close";

  private static final String SEND_WEIGHT = "ru.kassa.action.cart.config.SEND_WEIGHT";
  private static final String SEND_VENDOR_NAME = "ru.kassa.action.cart.config.SEND_VENDOR_NAME";
  private static final String SEND_MODEL_NAME = "ru.kassa.action.cart.config.SEND_MODEL_NAME";

  @Override
  public void onReceive(Context context, Intent intent) {
    final String action = intent.getAction();

    switch (action) {
      case START_GET_WEIGHT:
        Log.d(KassatkaScalesBroadcastReceiver.class.getName(), "Send weight, vendor_name and model_name");
        sendBrodcastAction(SEND_WEIGHT, "PRODUCT_WEIGHT", 200L, context);
        sendBrodcastAction(SEND_VENDOR_NAME, "VENDOR_NAME", "THIS is VENDOR NAME", context);
        sendBrodcastAction(SEND_MODEL_NAME, "MODEL_NAME", "THIS is MODEL NAME", context);

        break;
      case STOP_GET_WEIGHT:

      default:
        break;
    }
  }

  private void sendBrodcastAction(String Action, String extra, String value, Context context) {
    Intent intent1 = new Intent(Action);
    intent1.putExtra(extra, value);
    context.sendBroadcast(intent1);
  }

  private void sendBrodcastAction(String action, String extra, Long value, Context context) {
    Intent intent1 = new Intent(action);
    intent1.putExtra(extra, value);
    context.sendBroadcast(intent1);
  }
}
