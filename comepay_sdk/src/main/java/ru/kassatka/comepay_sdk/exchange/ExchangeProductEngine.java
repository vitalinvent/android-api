package ru.kassatka.comepay_sdk.exchange;

import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;

import ru.kassatka.comepay_sdk.CreateExtraJson;
import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Extra;
import ru.kassatka.comepay_sdk.model.Item;
import ru.kassatka.comepay_sdk.model.ProductItems;

public abstract class ExchangeProductEngine implements ExchangesInteface {


    public void Send(Context context, ArrayList<Item> items, String packageName, CallBack callBack){
        ArrayList<Object> itemsObjects = new ArrayList<>();
        for (Item item:items) {
            itemsObjects.add((Object)item);
        }
        context.sendBroadcast(new Intent(packageName+".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJsonFromArrayList(itemsObjects)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void Send(Context context, Item item, String packageName, CallBack callBack) {
        context.sendBroadcast(new Intent(packageName+".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJsonFromArrayList(item)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }


    @Override
    public void Send(Context context, Object obj, String packageName, CallBack callBack) {
        context.sendBroadcast(new Intent(packageName+".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJsonFromArrayList(obj)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void Send(Context context) {

    }

//    @Override
//    public void Send(Context context, String packageName, Extra extra) {
//        context.sendBroadcast(new Intent(packageName+".getpositions")
//                .putExtras(extra.));
//    }

    @Override
    public void Send(Object obj, String packageName) {

    }

    @Override
    public void Add(Context context, Item item, String packageName, CallBack callBack) {

    }

    @Override
    public void Add(Context context, Object obj, String packageName, CallBack callBack) {

    }

    @Override
    public void Add(Object obj, String packageName) {

    }

    @Override
    public void Del(Context context, Object obj, String packageName, CallBack callBack) {

    }

    @Override
    public void Del(Context context, Item item, String packageName, CallBack callBack) {

    }

    @Override
    public void NewExtra() {

    }
}
