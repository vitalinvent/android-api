package ru.kassatka.comepay_sdk.callBack;

/** Callbak for different type of actions. */
public interface CallbackListener extends CallBack {

  /**
   * Calls when command was successful.
   *
   * @param responce - data with command result.
   */
  void OnSuccess(String responce);

  /**
   * Calls when command was unsuccessful.
   *
   * @param message - data with command result.
   */
  void OnError(int code, String message);
}
