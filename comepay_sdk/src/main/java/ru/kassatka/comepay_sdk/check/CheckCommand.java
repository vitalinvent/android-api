package ru.kassatka.comepay_sdk.check;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import ru.kassatka.comepay_sdk.CreateExtraJson;
import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Complex;
import ru.kassatka.comepay_sdk.model.Extra;
import ru.kassatka.comepay_sdk.model.ProductItems;


/**
 * Created by sokolov on 23.07.2018.
 */

public final class CheckCommand {
    private Extra extra = new Extra();

    public  void openCheckCommand(@Nullable Extra extra){

        this.extra = extra;
    }

    public void complexCommand(@Nullable Complex complex, @Nullable Extra extra){
        this.extra = extra;

    }
    public void complexCommand(@Nullable String complex, @Nullable Extra extra){
        this.extra = extra;
        extra.putExtra("COMPLEX", complex);
    }

    public void complexCommand(@Nullable JsonObject complex, @Nullable Extra extra){
        this.extra = extra;
        extra.putExtra("COMPLEX", complex);
    }

    public  void addItemsCommand(@Nullable ArrayList<ProductItems> changes, @Nullable Extra extra){
        extra.putExtra("Lines", CreateExtraJson.createProduct(changes));
        this.extra = extra;
    }

    public void RemoveItemsCommand(@Nullable ArrayList<ProductItems> changes, @Nullable Extra extra){
        extra.putExtra("Lines", CreateExtraJson.createProduct(changes));
        CreateExtraJson.createProduct(changes);
    }

    public void CloseCheckCommand(@Nullable Extra extra) {
        this.extra = extra;
    }

    public void startCommand(Context context, CallBack callBack){

        context.sendBroadcast(new Intent("kassa.action.send.check.command")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(),context)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }
}
