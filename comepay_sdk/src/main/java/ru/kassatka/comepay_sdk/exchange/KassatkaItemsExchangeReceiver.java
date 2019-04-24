package ru.kassatka.comepay_sdk.exchange;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.List;

import ru.kassatka.comepay_sdk.CreateExtraJson;
import ru.kassatka.comepay_sdk.model.Item;

public class KassatkaItemsExchangeReceiver extends BroadcastReceiver {

    public static final String RESEIVE_ITEMS = "ru.kassa.receive.items";
    public static final String RESEIVE_ITEM = "ru.kassa.receive.item";
    public static final String JSON_LIST_ITEMS= "JSON_LIST_ITEMS";
    public static final String JSON_ITEM = "JSON_ITEM";
    public static final String PACKAGE_NAME = "PACKAGE_NAME";

    Listener listener;

    public void KassatkaItemsExchangeReceiver(Listener listener){ this.listener=listener; }

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
//        intent.getStringExtra(PACKAGE_NAME).equals(context.getPackageName())
        switch (action){
            case RESEIVE_ITEMS:
                String jsonListItems = intent.getStringExtra(JSON_LIST_ITEMS);
                listener.receiveItems(CreateExtraJson.DeserializeJsomStringToListItems(jsonListItems));
                break;
            case RESEIVE_ITEM:
                String jsonItem = intent.getStringExtra(JSON_LIST_ITEMS);
                listener.receiveItems(CreateExtraJson.DeserializeJsomStringToListItems(jsonItem));
                default:
                break;
        }
    }

    public interface Listener{

        void receiveItems(Item[] items);

        void receiveItem(Item item);
    }
}