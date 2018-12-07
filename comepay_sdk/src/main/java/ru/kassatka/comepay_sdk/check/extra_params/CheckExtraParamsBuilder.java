package ru.kassatka.comepay_sdk.check.extra_params;

import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;

import java.util.List;

/**
 * Builder for sending check extra params to Kassatka application.
 */
public class CheckExtraParamsBuilder {

  public static final String ADD_PHONE_OF_TRANSFER_OPERATOR_ACTION = "ru.kassa.service.print.ADD_PHONE_OF_TRANSFER_OPERATOR";
  public static final String ADD_OPERATION_OF_PAYMENT_AGENT_ACTION = "ru.kassa.service.print.ADD_OPERATION_OF_PAYMENT_AGENT";
  public static final String ADD_PHONE_OF_PAYMENT_AGENT_ACTION = "ru.kassa.service.print.ADD_PHONE_OF_PAYMENT_AGENT";
  public static final String ADD_PHONE_OF_GET_PAYMENT_OPERATOR_ACTION = "ru.kassa.service.print.ADD_PHONE_OF_GET_PAYMENT_OPERATOR";
  public static final String ADD_NAME_OF_TRANSFER_OPERATOR_ACTION = "ru.kassa.service.print.ADD_NAME_OF_TRANSFER_OPERATOR";
  public static final String ADD_INN_OF_TRANSFER_OPERATOR_ACTION = "ru.kassa.service.print.ADD_INN_OF_TRANSFER_OPERATOR";
  public static final String ADD_PHONE_OF_PROVIDER_ACTION = "ru.kassa.service.print.ADD_PHONE_OF_PROVIDER";
  public static final String ADD_ADDITIONAL_DOCUMENT_REQUISITE_ACTION = "ru.kassa.service.print.ADD_ADDITIONAL_DOCUMENT_REQUISITE";
  public static final String ADD_PHONE_OR_EMAIL_OF_CUSTOMER_ACTION = "ru.kassa.service.print.ADD_PHONE_OR_EMAIL_OF_CUSTOMER";
  public static final String ADD_EMAIL_OF_DEVICE_USER_ACTION = "ru.kassa.service.print.ADD_EMAIL_OF_DEVICE_USER";
  public static final String ADD_ADDRESS_OF_TRANSFER_OPERATOR = "ru.kassa.service.print.ADD_ADDRESS_OF_TRANSFER_OPERATOR";
  public static final String ADD_USER_REQUISITE = "ru.kassa.service.print.ADD_USER_REQUISITE";
  private static final String VALUE = "VALUE";
  private static final String TITLE = "TITLE";

  private Context context;

  /**
   * Constrictor of {@link CheckExtraParamsBuilder}.
   *
   * @param context - context for sending broadcast.
   */
  public CheckExtraParamsBuilder(Context context) {
    this.context = context;
  }

  /**
   * Send broadcast action for adding phone of transfer operator.
   *
   * @param value - value of phone.
   */
  public void addPhoneOfTransferOperator(String value) {
    sendBroadcastIntent(ADD_PHONE_OF_TRANSFER_OPERATOR_ACTION, value);
  }

  /**
   * Send broadcast action for adding operation of payment agent.
   *
   * @param value - operation of payment agent.
   */
  public void addOperationOfPaymentAgent(String value) {
    sendBroadcastIntent(ADD_OPERATION_OF_PAYMENT_AGENT_ACTION, value);
  }

  /**
   * Send broadcast action for adding phone of payment agent.
   *
   * @param value - phone of payment agent.
   */
  public void addPhoneOfPaymentAgent(String value) {
    sendBroadcastIntent(ADD_PHONE_OF_PAYMENT_AGENT_ACTION, value);
  }

  /**
   * Send broadcast action for adding phone of getPayment operator.
   *
   * @param value - phone.
   */
  public void addPhoneOfGetPaymentOperator(String value) {
    sendBroadcastIntent(ADD_PHONE_OF_GET_PAYMENT_OPERATOR_ACTION, value);
  }

  /**
   * Send broadcast action for adding name of transfer operator.
   *
   * @param value - name.
   */
  public void addNameOfTransferOperator(String value) {
    sendBroadcastIntent(ADD_NAME_OF_TRANSFER_OPERATOR_ACTION, value);
  }

  /**
   * Send broadcast action for adding INN of transfer operator.
   *
   * @param value - INN.
   */
  public void addInnOfTransferOperator(String value) {
    sendBroadcastIntent(ADD_INN_OF_TRANSFER_OPERATOR_ACTION, value);
  }

  /**
   * Send broadcast action for adding phone of provider.
   *
   * @param value - phone.
   */
  public void addPhoneOfProvider(String value) {
    sendBroadcastIntent(ADD_PHONE_OF_PROVIDER_ACTION, value);
  }

  /**
   * Send broadcast action for adding additional document requisite.
   *
   * @param value - additional document requisite.
   */
  public void addAdditionalDocumentRequisite(String value) {
    sendBroadcastIntent(ADD_ADDITIONAL_DOCUMENT_REQUISITE_ACTION, value);
  }

  /**
   * Send broadcast action for adding phone or email of customer.
   *
   * @param value - phone or email of customer.
   */
  public void addPhoneOrEmailOfCustomer(String value) {
    sendBroadcastIntent(ADD_PHONE_OR_EMAIL_OF_CUSTOMER_ACTION, value);
  }

  /**
   * Send broadcast action for adding email of device user.
   *
   * @param value - email of device user.
   */
  public void addEmailOfDeviceUser(String value) {
    sendBroadcastIntent(ADD_EMAIL_OF_DEVICE_USER_ACTION, value);
  }

  /**
   * Send broadcast action for adding address of transfer operator.
   *
   * @param value - address of transfer operator.
   */
  public void addAddressOfTransferOperator(String value) {
    sendBroadcastIntent(ADD_ADDRESS_OF_TRANSFER_OPERATOR, value);
  }

  /**
   * Send broadcast action for adding user requisite.
   *
   * @param value - value of user requisite.
   * @param title - title of user requisite.
   */
  public void addUserRequisite(String value, String title) {
    sendBroadcastIntent(ADD_USER_REQUISITE, value, title);
  }

  /**
   * Send extra params to Kassatka application.
   *
   * @param extraParams - {@link Pair} where first is action for {@link android.content.BroadcastReceiver} and second is value.
   */
  public void addExtraParamsList(List<Pair<String, String>> extraParams) {
    for (Pair<String, String> pair : extraParams) {
      sendBroadcastIntent(pair.first, pair.second);
    }
  }

  /**
   * Send user requisite extra params to Kassatka application.
   *
   * @param extraParams - {@link Pair} where first is value and second is title of user requisite.
   */
  public void addExtraParamsUserRequisite(List<Pair<String, String>> extraParams) {
    for (Pair<String, String> pair : extraParams) {
      sendBroadcastIntent(ADD_USER_REQUISITE, pair.first, pair.second);
    }
  }

  private void sendBroadcastIntent(String tag, String value) {
    Intent intent = new Intent(tag);
    intent.putExtra(VALUE, value);
    context.sendBroadcast(intent);
  }

  private void sendBroadcastIntent(String tag, String value, String title) {
    Intent intent = new Intent(tag);
    intent.putExtra(VALUE, value);
    intent.putExtra(TITLE, title);
  }

}
