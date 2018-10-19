package ru.kassatka.comepay_sdk.callBack;

import java.util.HashMap;


/**
 * Created by sokolov on 09.08.2018.
 */

public class CallbackHandler  {

    public HashMap<String, CallBack> listeners = new HashMap<>();

    /****************************************
     *           Initialization
     ***************************************/

    public final static CallbackHandler instance = new CallbackHandler();

    private CallbackHandler() {

    }


}
