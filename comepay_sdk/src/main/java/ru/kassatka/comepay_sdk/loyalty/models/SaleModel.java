package ru.kassatka.loyalty_4client.loyalty.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class SaleModel {
  public String store;

  @SerializedName("sale_sum")
  public double saleSum;

  @SerializedName("money_sum")
  public double moneySum;

  @SerializedName("bonus_sum")
  public double bonusSum;

  public Date datetime;

  @SerializedName("additional_info")
  public DeviceStatus additionalInfo;
}
