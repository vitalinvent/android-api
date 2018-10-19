package ru.kassatka.comepay_sdk.callBack;


/**
 * Created by sokolov on 14.08.2018.
 */

public interface DiscountCallBack extends CallBack {
    void OnSuccess(Boolean isSetDiscount);
    void OnError(String msg);
}
