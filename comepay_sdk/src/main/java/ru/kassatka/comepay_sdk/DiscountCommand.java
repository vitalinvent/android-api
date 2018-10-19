package ru.kassatka.comepay_sdk;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.UUID;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Extra;

/** Created by sokolov on 14.08.2018. */
public class DiscountCommand {

  private UUID uuid;
  private Extra extra;

  public void setDiscountCategory(@Nullable Extra extra) {
    this.extra = extra;
  }

  public void setDiscountPosition(@Nullable UUID posstion, @Nullable Extra extra) {
    this.extra = extra;
    uuid = posstion;
  }

  public void setDiscountAllCheck(@Nullable Extra extra) {
    this.extra = extra;
  }

  public void startCommand(Context context, CallBack callBack) {
    context.sendBroadcast(
        new Intent("kassa.action.send.discount.command")
            .putExtra("UUID", uuid)
            .putExtra("PackageName", context.getPackageName())
            .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(), context)));
    CallbackHandler.instance.listeners.put("Discount", callBack);
  }
}
