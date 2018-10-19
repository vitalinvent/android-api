package ru.kassatka.comepay_sdk.check.extra_params;

import android.content.Context;
import android.content.Intent;

public class CheckPaymentEvents {
  private static final String SUCCESSFUL_PAYMENT =
      "ru.kassa.service.kassa.PaymentReceiver.SUCCESSFUL_PAYMENT";
  private static final String UNSUCCESSFUL_PAYMENT =
      "ru.kassa.service.kassa.PaymentReceiver.UNSUCCESSFUL_PAYMENT";
  private static final String CHECK_ID = "CHECK_ID";

  public static void successfulPaymentEvent(Context context, long checkId) {
    Intent intent = new Intent(SUCCESSFUL_PAYMENT);
    intent.putExtra(CHECK_ID, checkId);
    context.sendBroadcast(intent);
  }

  public static void unsuccessfulPaymentEvent(Context context, long checkId) {
    Intent intent = new Intent(UNSUCCESSFUL_PAYMENT);
    intent.putExtra(CHECK_ID, checkId);
    context.sendBroadcast(intent);
  }
}
