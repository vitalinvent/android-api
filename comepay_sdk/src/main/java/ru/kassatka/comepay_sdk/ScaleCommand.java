package ru.kassatka.comepay_sdk;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Extra;


/**
 * Created by sokolov on 13.08.2018.
 */

public class ScaleCommand {
    private Extra extra;

    public void setModel(Extra extra){
         this.extra = extra;
    }

    public void setName(@Nullable Extra extra) {
        this.extra = extra;
    }

    public void startCommand(Context context, CallBack callBack){
        context.sendBroadcast(new Intent("kassa.action.send.scale.command")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(),context))
        );
        CallbackHandler.instance.listeners.put("Scale", callBack);
    }
}
