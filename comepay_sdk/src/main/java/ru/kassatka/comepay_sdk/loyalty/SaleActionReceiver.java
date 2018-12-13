package ru.kassatka.comepay_sdk.loyalty;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import ru.kassatka.comepay_sdk.loyalty.models.SaleModel;


public class SaleActionReceiver extends BroadcastReceiver {
  private static final String ACTION_SALE =
      "ru.kassatka.loyalty_4client.receivers.action.sale";

  private Listener listener;

  public interface Listener {
    void saleActionReceived(String cardNumber, SaleModel saleModel);
  }

  public SaleActionReceiver(Listener listener) {
    this.listener = listener;
  }

  private static final String DATA = "DATA";
  private static final String CARD_NUMBER = "CARD_NUMBER";

  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    switch (action) {
      case ACTION_SALE:
        String data = intent.getStringExtra(DATA);
        String cardNumber = intent.getStringExtra(CARD_NUMBER);
        Gson gson =
            new GsonBuilder()
                .enableComplexMapKeySerialization()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
        listener.saleActionReceived(cardNumber, gson.fromJson(data, SaleModel.class));
        break;
      default:
    }

  }
}
