package ru.kassatka.comepay_sdk.exchange;

import java.util.ArrayList;
import android.content.Intent;
import android.content.Context;
import ru.kassatka.comepay_sdk.model.Item;
import ru.kassatka.comepay_sdk.model.Extra;
import ru.kassatka.comepay_sdk.CreateExtraJson;
import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;

public class ExchangeProductEngine implements ExchangesInteface {

    private Extra extra;
    private Context context;
    private CallBack callBack;
    private String packageNameReceiver;

    public ExchangeProductEngine(Context context,String packageNameReceiver) {
        this.extra = new Extra();
        this.context = context;
        this.packageNameReceiver = packageNameReceiver;
    }

    @Override
    public void Send(ArrayList<Item> items, CallBack callBack){
        ArrayList<Object> itemsObjects = new ArrayList<>();
        for (Item item:items) {
            itemsObjects.add((Object)item);
        }
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(itemsObjects)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void Send(ArrayList<Item> items){
        ArrayList<Object> itemsObjects = new ArrayList<>();
        for (Item item:items) {
            itemsObjects.add((Object)item);
        }
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(itemsObjects)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void Send(Item item, CallBack callBack) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(item)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void Send(Object obj, CallBack callBack) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(obj)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void Send() {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(extra.getExtra(),context)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void Send(Object obj) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(obj)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void AddExtra(Item item, CallBack callBack) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(item)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void AddExtra(Object obj, CallBack callBack) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(obj)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void AddExtra(Object obj) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(obj)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void DelExtra(Object obj, CallBack callBack) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(obj)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void DelExtra(Item item, CallBack callBack) {
        context.sendBroadcast(new Intent(this.packageNameReceiver +".getpositions")
                .putExtra("PackageName", context.getPackageName())
                .putExtra("Json", CreateExtraJson.createJson(item)));
        CallbackHandler.instance.listeners.put("Check", callBack);
    }

    @Override
    public void NewExtra() {
        extra = new Extra();
    }
}
