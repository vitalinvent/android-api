package ru.kassatka.comepay_sdk.loyalty.bonuses;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.math.BigDecimal;

/** Handling bonuses actions class. */
public class LoyaltyBonusesReceiver extends BroadcastReceiver {

  private static final String LOYALTY_TOTAL_PRICE =
      "ru.kassatka.comepay_sdk.loyalty.action.send.total_price";
  private static final String BONUSES_WRITE_OFF =
      "ru.kassatka.comepay_sdk.loyalty.action.write_off.bonuses";
  private static final String BONUSES_WRITE_OFF_ALL =
      "ru.kassatka.comepay_sdk.loyalty.action.write_off.all_bonuses";
  private static final String TOTAL_PRICE = "TOTAL_PRICE";
  private static final String BONUSES = "BONUSES";
  private static final String CARD_NUMBER = "CARD_NUMBER";

  private Listener listener;

  /** Default constructor. */
  public LoyaltyBonusesReceiver() {
    listener =
        new Listener() {
          @Override
          public void receivedTotalPrice(BigDecimal totalPrice) {
            Log.d(
                LoyaltyBonusesReceiver.class.getName(),
                "Total price was received: " + totalPrice.doubleValue() + ".");
          }

          @Override
          public void receivedBonusesWriteOffAction(BigDecimal bonuses) {
            Log.d(
                LoyaltyBonusesReceiver.class.getName(),
                "Bonuses write off action was received: " + bonuses.doubleValue() + ".");
          }

          @Override
          public void receivedAllBonusesWriteOffAction() {
            Log.d(
                LoyaltyBonusesReceiver.class.getName(),
                "All bonuses write off action was received.");
          }
        };
  }

  /**
   * Constructor with {@link Listener} interface.
   *
   * @param listener - interface for users actions processing.
   */
  public LoyaltyBonusesReceiver(Listener listener) {
    this.listener = listener;
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    switch (action) {
      case LOYALTY_TOTAL_PRICE:
        BigDecimal totalPrice = (BigDecimal) intent.getSerializableExtra(TOTAL_PRICE);
        listener.receivedTotalPrice(totalPrice);
        break;
      case BONUSES_WRITE_OFF:
        BigDecimal bonuses = (BigDecimal) intent.getSerializableExtra(BONUSES);
        listener.receivedBonusesWriteOffAction(bonuses);
        break;
      case BONUSES_WRITE_OFF_ALL:
        listener.receivedAllBonusesWriteOffAction();
        break;
      default:
        break;
    }
  }

  /** Interface to handle actions. */
  public interface Listener {

    /**
     * Event called upon received check total price.
     *
     * @param totalPrice - check total price.
     */
    void receivedTotalPrice(BigDecimal totalPrice);

    /**
     * Event called upon bonuses write off action need.
     *
     * @param bonuses - written off bonuses
     */
    void receivedBonusesWriteOffAction(BigDecimal bonuses);

    /** Event called upon all bonuses write off action need. */
    void receivedAllBonusesWriteOffAction();
  }
}
