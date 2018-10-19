package ru.kassatka.comepay_sdk.callBack;


/**
 * Created by sokolov on 13.08.2018.
 */

public interface ShiftCallBack extends CallBack {
     void OnSuccess(Long shiftNum, Boolean shiftIsOpen);
     void OnError(String msg);
}
