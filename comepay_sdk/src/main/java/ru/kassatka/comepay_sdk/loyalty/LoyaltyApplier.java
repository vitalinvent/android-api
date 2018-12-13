package ru.kassatka.comepay_sdk.loyalty;

import android.content.Context;
import android.content.Intent;

import com.google.gson.Gson;

import ru.kassatka.comepay_sdk.loyalty.models.BaseLoyaltyCard;

public class LoyaltyApplier<T extends BaseLoyaltyCard> {

  public final void applyLoyalty(Context context, T card, LoyaltySystem loyaltySystem) {
    String cardString = new Gson().toJson(card);
    Intent intent = new Intent("ru.kassatka.loyalty_4client.update.loyalty_card");
    intent.putExtra("LOYALTY_CARD", cardString);
    intent.putExtra("LOYALTY_SYSTEM", loyaltySystem.value);
    context.sendBroadcast(intent);
  }
}
