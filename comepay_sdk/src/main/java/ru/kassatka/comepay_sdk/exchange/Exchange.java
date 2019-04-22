package ru.kassatka.comepay_sdk.exchange;

import android.content.Context;

import java.util.ArrayList;

import ru.kassatka.comepay_sdk.callBack.CallBack;
import ru.kassatka.comepay_sdk.callBack.CallbackHandler;
import ru.kassatka.comepay_sdk.model.Extra;

public class Exchange {

    private ExchangesInteface exchangesInteface;
    private Context context;
    private Extra extra = new Extra();
    private String packageNameRecivier="";
    private CallBack callBack;

    public Exchange(ExchangesInteface exchangesInteface, Context context,String packageNameRecivier) {
        this.exchangesInteface = exchangesInteface;
        this.context = context;
        this.packageNameRecivier=packageNameRecivier;
    }

    public void Send(Object obj){
        exchangesInteface.Send(context,obj,packageNameRecivier,callBack);
    }

    public void Send(ArrayList<Object> objects){
        exchangesInteface.Send(context,objects,packageNameRecivier,callBack);
    }


}
