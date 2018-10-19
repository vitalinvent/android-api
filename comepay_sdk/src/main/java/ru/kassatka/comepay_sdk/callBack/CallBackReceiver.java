package ru.kassatka.comepay_sdk.callBack;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

/**
 * Created by sokolov on 09.08.2018.
 */

public class CallBackReceiver extends BroadcastReceiver {
    public static final String Check = "sdk.action.call.back.check";
    public static final String Report= "sdk.action.call.back.shift.report";
    public static final String Status = "sdk.action.call.back.shift.status";
    public static final String Print = "sdk.action.call.back.print";
    public static final String Discount = "sdk.action.call.back.discount";

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if(TextUtils.isEmpty(action)) return;
        Bundle bundle = intent.getExtras();
        switch (action) {
            case Check:
                CallbackListener listener = (CallbackListener) CallbackHandler.instance.listeners.get("Check");
                if(bundle.getInt("ErrorCode") == 0){
                    listener.OnSuccess( bundle.getString("Response"));
                }else {
                    listener.OnError(bundle.getInt("ErrorCode"), bundle.getString("ErrorMessage"));
                }
                break;
            case Report:
                CallBackPrint reportListener = (CallBackPrint) CallbackHandler.instance.listeners.get("Shift");
                reportListener.result(bundle.getBoolean("PrintReport"));
                break;
            case Status:
                ShiftCallBack statusListener = (ShiftCallBack) CallbackHandler.instance.listeners.get("Shift");
                statusListener.OnSuccess( bundle.getLong("Shift"), bundle.getBoolean("IsOpen"));
                statusListener.OnError(bundle.getString("Error"));
                break;
            case Print:
                CallBackPrint printListener = (CallBackPrint) CallbackHandler.instance.listeners.get("Print");
                printListener.result(bundle.getBoolean("IsPrint"));
                break;
            case Discount:
                DiscountCallBack discountCallBack = (DiscountCallBack) CallbackHandler.instance.listeners.get("Discount");
                discountCallBack.OnSuccess(intent.getExtras().getBoolean("IsSetDiscount"));
                discountCallBack.OnError(intent.getExtras().getString("Error"));
                break;
        }
    }
}
