package ru.kassatka.comepay_sdk.exchange;

import android.content.Context;

import java.util.ArrayList;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.model.Item;

public class Exchange implements ExchangesInteface {

    private ExchangesInteface exchangesEngine;
    private Context context;

    public Exchange(ExchangeType exchangeType, Context context,String packageNameReceiver) {
        switch (exchangeType){
            case PRODUCTS:
                exchangesEngine=new ExchangeProductEngine(context, packageNameReceiver);
                break;
            case DISCOUNTS:
                break;
            case STUB:
                exchangesEngine=new ExchangeProductStub(context, packageNameReceiver);
                break;
                default:
                    break;
        }
        this.context = context;
    }

    @Override
    public void Send(ArrayList<Item> productItems, CallBack callBack) {
        exchangesEngine.Send(productItems, callBack);
    }

    @Override
    public void Send(ArrayList<Item> items) {

    }

    @Override
    public void Send(Item item, CallBack callBack) {
        exchangesEngine.Send(item, callBack);
    }

    @Override
    public void Send(Object obj, CallBack callBack) {
        exchangesEngine.Send(obj, callBack);
    }

    @Override
    public void Send() {
        exchangesEngine.Send();
    }

    @Override
    public void Send(Object obj) {

    }

    @Override
    public void AddExtra(Item item, CallBack callBack) {

    }

    @Override
    public void AddExtra(Object obj, CallBack callBack) {

    }

    @Override
    public void AddExtra(Object obj) {

    }

    @Override
    public void DelExtra(Object obj, CallBack callBack) {

    }

    @Override
    public void DelExtra(Item item, CallBack callBack) {

    }

    @Override
    public void NewExtra() {

    }

    public enum ExchangeType {
        PRODUCTS,
        DISCOUNTS,
        STUB
    }
}