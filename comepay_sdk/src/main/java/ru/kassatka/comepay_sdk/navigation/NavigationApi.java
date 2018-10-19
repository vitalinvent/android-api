package ru.kassatka.comepay_sdk.navigation;

import android.content.Context;
import android.content.Intent;

public class NavigationApi {
  private static final String APP_PACKAGE = "ru.kassa";
  private static final String ACCOUNTING_ACTIVITY =
      APP_PACKAGE + ".ui.accounting.AccountingActivity";
  private static final String SALE_QUICK_ACTIVITY = APP_PACKAGE + ".ui.sale.quick.SaleQuickActivity";
  private static final String CART_CONFIG_ACTIVITY =
      APP_PACKAGE + ".ui.cart.config.CartConfigActivity";
  private static final String HELP_ACTIVITY = APP_PACKAGE + ".ui.help.HelpActivity";
  private static final String OFD_INFO_ACTIVITY = APP_PACKAGE + ".ui.ofd.OfdInfoActivity";
  private static final String MANUAL_SHIFT_ACTIVITY = APP_PACKAGE + ".ui.shift.manual.ManualShiftActivity";
  private static final String BALANCE_ACTIVITY = APP_PACKAGE + ".ui.balance.BalanceActivity";
  private static final String TRANSACTIONS_ACTIVITY =
      APP_PACKAGE + ".ui.transactions.list.TransactionsActivity";
  private static final String TRANSACTIONS_CARD_ACTIVITY =
      APP_PACKAGE + ".ui.transactions.card.TransactionCardActivity";
  private static final String SHIFT_ACTIVITY = APP_PACKAGE + ".ui.shift.ShiftActivity";
  private static final String CREATE_PRODUCT_ACTIVITY =
      APP_PACKAGE + ".ui.nomenclature.CreateProductActivity";
  private static final String SALE_ACTIVITY = APP_PACKAGE + ".ui.sale.SaleActivity";
  private static final String CART_ACTIVITY = APP_PACKAGE + ".ui.cart.CartActivity";
  private static final String PAYMENT_CASH_ACTIVITY =
      APP_PACKAGE + ".ui.payment.cash.PaymentCashActivity";
  private static final String DISCOUNT_ACTIVITY = APP_PACKAGE + ".ui.discount.DiscountActivity";
  private static final String SEND_CHECK_ACTIVITY = APP_PACKAGE + ".ui.client.SendCheckActivity";
  private static final String CORRECTION_ACTIVITY =
      APP_PACKAGE + ".ui.correction.CorrectionActivity";
  private static final String ADD_CLIENT_ACTIVITY =
      APP_PACKAGE + ".ui.client.loyalty.AddClientActivity";
  private static final String CHECK_ID_EXTRA = "CHECK_ID_EXTRA";


  public static Intent createAccountingActivityIntent() {
    return new Intent(ACCOUNTING_ACTIVITY);
  }

  public static Intent createSaleQuickActivityIntent() {
    return new Intent(SALE_QUICK_ACTIVITY);
  }

  public static Intent createCartConfigActivityIntent() {
    return new Intent(CART_CONFIG_ACTIVITY);
  }

  public static Intent createHelpActivityIntent() {
    return new Intent(HELP_ACTIVITY);
  }

  public static Intent createOfdInfoActivityIntent() {
    return new Intent(OFD_INFO_ACTIVITY);
  }

  public static Intent createManualShiftActivityIntent() {
    return new Intent(MANUAL_SHIFT_ACTIVITY);
  }

  public static Intent createBalanceActivityIntent(boolean isPayout) {
    Intent intent = new Intent(BALANCE_ACTIVITY);
    intent.putExtra("EXTRA_IS_PAYOUT", isPayout);
    return intent;
  }

  public static Intent createTransactionsActivityIntent() {
    return new Intent(TRANSACTIONS_ACTIVITY);
  }

  public static Intent createTransactionsCardActivityIntent(long checkId) {
    Intent transactionsCardActivityIntent = new Intent(TRANSACTIONS_CARD_ACTIVITY);
    transactionsCardActivityIntent.putExtra(CHECK_ID_EXTRA, checkId);
    return transactionsCardActivityIntent;
  }

  public static Intent createShiftActivityIntent() {
    return new Intent(SHIFT_ACTIVITY);
  }

  public static Intent createCreateProductActivityIntent() {
    return new Intent(CREATE_PRODUCT_ACTIVITY);
  }

  public static Intent createSaleActivityIntent() {
    return new Intent(SALE_ACTIVITY);
  }

  public static Intent createCartActivityIntent() {
    return new Intent(CART_ACTIVITY);
  }

  public static Intent createPaymentCashActivityIntent() {
    return new Intent(PAYMENT_CASH_ACTIVITY);
  }

  public static Intent createDiscountActivityIntent() {
    return new Intent(DISCOUNT_ACTIVITY);
  }

  public static Intent createSendCheckActivityIntent() {
    return new Intent(SEND_CHECK_ACTIVITY);
  }

  public static Intent createCorrectionActivityIntent() {
    return new Intent(CORRECTION_ACTIVITY);
  }

  public static Intent createAddClientActivityIntent() {
    return new Intent(ADD_CLIENT_ACTIVITY);
  }

  public static void startActivity(Context context, Intent intent) {
    context.startActivity(intent);
  }
}
