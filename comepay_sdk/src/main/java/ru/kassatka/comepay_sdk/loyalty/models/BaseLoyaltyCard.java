package ru.kassatka.comepay_sdk.loyalty.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class BaseLoyaltyCard implements Serializable {
  public String number;

  public String client;
  public String phone;
  public double balance;
  @SerializedName("is_active")
  public double isActive;

  @SerializedName("card_bonus")
  public double cardBonus;

  @SerializedName("card_discount")
  public double cardDiscount;

  @SerializedName("discount_name")
  public String discountName;

  /**
   * Copy constructor.
   *
   * @return - copy of card.
   */
  public BaseLoyaltyCard clone() {
    BaseLoyaltyCard res = new BaseLoyaltyCard();
    res.number = this.number;
    res.client = this.client;
    res.phone = this.phone;
    res.balance = this.balance;
    res.isActive = this.isActive;
    res.cardBonus = this.cardBonus;
    res.cardDiscount = this.cardDiscount;
    res.discountName = this.discountName;
    return res;
  }
}
