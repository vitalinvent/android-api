package ru.kassatka.comepay_sdk.loyalty.bonuses;

import android.content.Context;
import android.content.Intent;

import java.math.BigDecimal;

/** Class for bonuses action sending. */
public class LoyaltyBonusesActions {

  private static final String LOYALTY_TOTAL_PRICE =
      "ru.kassatka.comepay_sdk.loyalty.action.send.total_price";
  private static final String BONUSES_WRITE_OFF =
      "ru.kassatka.comepay_sdk.loyalty.action.write_off.bonuses";
  private static final String BONUSES_WRITE_OFF_ALL =
      "ru.kassatka.comepay_sdk.loyalty.action.write_off.all_bonuses";
  private static final String TOTAL_PRICE = "TOTAL_PRICE";
  private static final String BONUSES = "BONUSES";
  private static final String CARD_NUMBER = "CARD_NUMBER";

  private String cardNumber;
  private Context context;

  /**
   * Constructor for sending actions.
   *
   * @param context - context for broadcast sending.
   * @param cardNumber - client loyalty card number.
   */
  public LoyaltyBonusesActions(Context context, String cardNumber) {
    this.context = context;
    this.cardNumber = cardNumber;
  }

  /**
   * Send price to {@link LoyaltyBonusesReceiver}.
   *
   * @param context - context for broadcast sending.
   * @param cardNumber - client loyalty card number.
   * @param totalPrice - check total price.
   */
  public static void sendPrice(Context context, String cardNumber, BigDecimal totalPrice) {
    Intent intent = new Intent(LOYALTY_TOTAL_PRICE);
    intent.putExtra(TOTAL_PRICE, totalPrice);
    intent.putExtra(CARD_NUMBER, cardNumber);
    context.sendBroadcast(intent);
  }

  /**
   * Send bonuses write off action to {@link LoyaltyBonusesReceiver}.
   *
   * @param context - context for broadcast sending
   * @param cardNumber - client loyalty card number
   * @param bonuses - number of write off bonuses.
   */
  public static void sendBonusesWriteOff(Context context, String cardNumber, BigDecimal bonuses) {
    Intent intent = new Intent(BONUSES_WRITE_OFF);
    intent.putExtra(BONUSES, bonuses);
    intent.putExtra(CARD_NUMBER, cardNumber);
    context.sendBroadcast(intent);
  }

  /**
   * Send all bonuses write off action to {@link LoyaltyBonusesReceiver}.
   *
   * @param context - context for broadcast sending
   * @param cardNumber - client loyalty card number
   */
  public static void sendAllBonusesWriteOff(Context context, String cardNumber) {
    Intent intent = new Intent(BONUSES_WRITE_OFF_ALL);
    intent.putExtra(CARD_NUMBER, cardNumber);
    context.sendBroadcast(intent);
  }

  /**
   * Send price to {@link LoyaltyBonusesReceiver}.
   *
   * @param totalPrice - check total price.
   */
  public void sendPrice(BigDecimal totalPrice) {
    sendPrice(context, cardNumber, totalPrice);
  }

  /**
   * Send bonuses write off action to {@link LoyaltyBonusesReceiver}.
   *
   * @param bonuses - number of write off bonuses.
   */
  public void sendBonusesWriteOff(BigDecimal bonuses) {
    sendBonusesWriteOff(context, cardNumber, bonuses);
  }

  /** Send all bonuses write off action to {@link LoyaltyBonusesReceiver}. */
  public void sendAllBonusesWriteOff() {
    sendAllBonusesWriteOff(context, cardNumber);
  }
}
