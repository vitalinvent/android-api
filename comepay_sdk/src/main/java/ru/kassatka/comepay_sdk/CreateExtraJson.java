package ru.kassatka.comepay_sdk;

import android.content.Context;

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

    public static String createJson(JsonObject json, Context context){
        try {
            json.addProperty("PACKAGE", context.getPackageName());
            return new String(json.toString().getBytes("UTF-8"), "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static JsonArray createProduct(ArrayList<ProductItems> items){
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
                    productJson.addProperty("SubTotal", 0);
                    productJson.addProperty("TaxId",  item.taxMode);
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
}
