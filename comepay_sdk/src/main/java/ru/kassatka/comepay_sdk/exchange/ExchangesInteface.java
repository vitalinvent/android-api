package ru.kassatka.comepay_sdk.exchange;

import android.content.Context;

import java.util.ArrayList;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.model.Item;
import ru.kassatka.comepay_sdk.model.ProductItems;

public interface ExchangesInteface {

   void Send(Context context, ArrayList<Item> productItems, String packageName, CallBack callBack);

   void Send(Context context, Item item, String packageName, CallBack callBack);

   void Send(Context context, Object obj, String packageName, CallBack callBack);

   void Send(Context context);

   void Send(Object obj, String packageName);

   void Add(Context context, Item item, String packageName, CallBack callBack);

   void Add(Context context, Object obj, String packageName, CallBack callBack);

   void Add(Object obj, String packageName);

   void Del(Context context, Object obj, String packageName, CallBack callBack);

   void Del(Context context, Item item, String packageName, CallBack callBack);

   void NewExtra();
}
