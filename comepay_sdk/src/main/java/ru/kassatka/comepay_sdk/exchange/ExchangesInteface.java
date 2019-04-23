package ru.kassatka.comepay_sdk.exchange;

import java.util.ArrayList;
import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.model.Item;

public interface ExchangesInteface {

   void Send(ArrayList<Item> items, CallBack callBack);

   void Send(ArrayList<Item> items);

   void Send(Item item, CallBack callBack);

   void Send(Object obj, CallBack callBack);

   void Send();

   void Send(Object obj);

   void AddExtra(Item item, CallBack callBack);

   void AddExtra(Object obj, CallBack callBack);

   void AddExtra(Object obj);

   void DelExtra(Object obj, CallBack callBack);

   void DelExtra(Item item, CallBack callBack);

   void NewExtra();
}
