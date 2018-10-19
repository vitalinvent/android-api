package ru.kassatka.comepay_sdk.model;

import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by sokolov on 23.07.2018.
 */

public class ProductItems {

    public String name;

    public String barcode;
    public String group;
    public int color;
    public int priority;
    public int count;
    public boolean freePrice = false;
    public boolean freeSale = false;
    public VatType vatType = VatType.NONE;
    public double price = 0.0;
    public String unit;
    public boolean isFavorite;
    public byte agentType;
    public GoodAttributesType goodAttributesType;
    public boolean isRemaindersControl;
    public double currentRemainders;
    public int taxMode = 1;
    public ProductType productType;

    public double alcoholByVolume; //Крепость.
    public long alcoholProductKindCode; //Код вида продукции ФСРАР.
    public double tareVolume; //Объём тары.
    public String extId;

    public ProductItems(){}

    public ProductItems(JSONObject object) throws JSONException {
        name = object.getString("Name");
        extId = object.getString("ExtId");
        group = object.getString("Group");
        price = object.getDouble("Price");
        try{
            count = object.getInt("Qty");
        }catch (Exception e){

        }
    }

    public enum ProductType {
        NORMAL, //Продукт
        ALCOHOL_MARKED, //Алкоголь с маркой
        ALCOHOL_NOT_MARKED, //Алкоголь без марки
        SERVICE //Услуга
    }

    public enum TaxMode {
        DEFAULT, //по умолчанию
        COMMON, //Общая
        SIMPLIFIED_INCOME, //    Упрощённая доход
        SIMPLIFIED_INCOME_OUTCOME, //Упрощённая доход минус расход
        SINGLE_IMPUTED_INCOME, //Единый налог на вменённый доход
        SINGLE_AGRICULTURE, //Единый сельскохозяйственный налог
        PATENT // Патентная система налогообложения
    }

    public enum AgentType {
        NONE,
        BANK_PAY_AGENT,
        BANK_PAY_SUB_AGENT,
        PAY_AGENT,
        PAY_SUB_AGENT,
        ATTORNEY,
        COMMISSION_AGENT,
        AGENT;
    }

    public enum VatType {
        NONE("Нет"),
        VAT_0("0%"),
        VAT_10("10%"),
        VAT_18("18%");

        public final String name;

        VatType(String name) {
            this.name = name;
        }

        public static BigDecimal calcVatSumIncluding(BigDecimal sum, VatType vatType) {
            switch (vatType) {
                case NONE:
                    return BigDecimal.ZERO;
                case VAT_0:
                    return BigDecimal.ZERO;
                case VAT_10:
                    return (sum.divide(BigDecimal.valueOf(1.10D), 2, RoundingMode.DOWN)).multiply(BigDecimal.valueOf(0.10D));
                case VAT_18:
                    return (sum.divide(BigDecimal.valueOf(1.18D), 2, RoundingMode.DOWN)).multiply(BigDecimal.valueOf(0.18D));
            }
            return BigDecimal.ZERO;
        }

        public static double getPercentByType(VatType vatType) {
            switch (vatType) {
                case NONE:
                    return 0D;
                case VAT_0:
                    return 0D;
                case VAT_10:
                    return 10D;
                case VAT_18:
                    return 18D;
            }
            return 0D;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    public enum GoodAttributesType {
        PRODUCT((short) 1, "ТОВАР"),
        EXCISABLE_GOODS((short) 2, "ПОДАКЦИЗНЫЙ ТОВАР"),
        WORK((short) 3, "РАБОТА"),
        SERVICE((short) 4, "УСЛУГА"),
        BET_GAMBLING((short) 5, "СТАВКА АЗАРТНОЙ ИГРЫ"),
        WIN_GAMBLING((short) 6, "ВЫИГРЫШ АЗАРТНОЙ ИГРЫ"),
        LOTTERY_TICKET((short) 7, "ЛОТЕРЕЙНЫЙ БИЛЕТ"),
        WINNING_LOTTERY((short) 8, "ВЫИГРЫШ ЛОТЕРЕИ"),
        INTELLECTUAL_PROPERTY_RESULTS((short) 9, "ПРЕДОСТАВЛЕНИЕ РИД"),
        PAYMENT_OR_PAYOUT((short) 10, "ПЛАТЕЖ ИЛИ ВЫПЛАТА"),
        AGENT_S_COMMISSION((short) 11, "АГЕНТСКОЕ ВОЗНАГРАЖДЕНИЕ"),
        COMPOSITE((short) 12, "СОСТАВНОЙ ПРЕДМЕТ РАСЧЕТА"),
        OTHER((short) 13, "ИНОЙ ПРЕДМЕТ РАСЧЕТА");

        public final short id;
        public final String name;

        GoodAttributesType(short id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

    }
}
