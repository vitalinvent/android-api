package ru.kassatka.comepay_sdk;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import ru.kassatka.comepay_sdk.model.ProductItems;


/**
 * Created by sokolov on 06.08.2018.
 */

public final class CreateExtraJson {
    static JsonArray array;

    public static String createJson(JsonObject json, Context context) {
        try {
            json.addProperty("PACKAGE", context.getPackageName());
            return new String(json.toString().getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static JsonArray createProduct(ArrayList<ProductItems> items) {
        array = new JsonArray();
        if (items.size() > 0) {
            try {
                for (ProductItems item : items) {
                    JsonObject productJson = new JsonObject();
                    byte[] ptext = item.name.toString().getBytes("UTF-8");
                    String values = new String(ptext, "UTF-8");
                    productJson.addProperty("Description", values.toString());
                    productJson.addProperty("Group", item.group);
                    productJson.addProperty("ExtId", item.extId);
                    productJson.addProperty("Price", item.price);
                    productJson.addProperty("Qty", item.count);
                    switch (item.taxMode) {
                        case DEFAULT:
                            productJson.addProperty("TaxMode", 0);
                            break;

                        case COMMON:
                            productJson.addProperty("TaxMode", 1);
                            break;

                        case SIMPLIFIED_INCOME:
                            productJson.addProperty("TaxMode", 2);
                            break;

                        case SIMPLIFIED_INCOME_OUTCOME:
                            productJson.addProperty("TaxMode", 4);
                            break;

                        case SINGLE_IMPUTED_INCOME:
                            productJson.addProperty("TaxMode", 8);
                            break;

                        case SINGLE_AGRICULTURE:
                            productJson.addProperty("TaxMode", 16);
                            break;

                        case PATENT:
                            productJson.addProperty("TaxMode", 32);
                            break;
                    }
                    if (item.subtotal > 0)
                        productJson.addProperty("SubTotal", item.subtotal);
                    switch (item.vatType) {
                        case NONE:
                            productJson.addProperty("TaxId", 4);
                            break;
                        case VAT_0:
                            productJson.addProperty("TaxId", 3);
                            break;
                        case VAT_10:
                            productJson.addProperty("TaxId", 2);
                            break;
                        case VAT_20:
                            productJson.addProperty("TaxId", 1);
                            break;
                    }
                    addProductJson(productJson);
                }

                JsonObject complex = new JsonObject();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return array;
    }

    private static void addProductJson(JsonObject jsonObject) {
        array.add(jsonObject);
    }

    public static String createJson(ArrayList<Object> objects) {
        String retVal="";
        try {
            retVal = new Gson().toJson(objects);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retVal;
    }

    public static String createJson(Object obj) {
        String retVal="";
        try {
            retVal = new Gson().toJson(obj);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return retVal;
    }

}
