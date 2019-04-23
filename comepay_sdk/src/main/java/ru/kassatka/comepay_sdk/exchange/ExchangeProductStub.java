package ru.kassatka.comepay_sdk.exchange;

import android.content.Context;

import java.util.ArrayList;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.model.Extra;
import ru.kassatka.comepay_sdk.model.Item;

public class ExchangeProductStub implements ExchangesInteface {


    private Extra extra;
    private Context context;
    private CallBack callBack;
    private String packageNameReceiver;

    public ExchangeProductStub(Context context,String packageNameReceiver) {
        this.extra = new Extra();
        this.context = context;
        this.packageNameReceiver = packageNameReceiver;
    }

    @Override
    public void Send(ArrayList<Item> productItems, CallBack callBack) {

    }

    @Override
    public void Send(ArrayList<Item> items) {

    }

    @Override
    public void Send(Item item, CallBack callBack) {

    }

    @Override
    public void Send(Object obj, CallBack callBack) {

    }

    @Override
    public void Send() {

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
}
