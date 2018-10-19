package ru.kassatka.comepay_sdk.model;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Created by sokolov on 23.07.2018.
 */

public class Extra {

    private JsonObject extras = new JsonObject();

    public void putExtra(String key, Boolean value)
    {
        extras.addProperty(key, value);
    }
    public void putExtra(String key, String value)
    {
        extras.addProperty(key, value);
    }
    public void putExtra(String key, int value)
    {
        extras.addProperty(key, value);
    }

    public void putExtra(String key, float value)
    {
        extras.addProperty(key, value);
    }
    public void putExtra(String key, Number value)
    {
        extras.addProperty(key, value);
    }

    public void putExtra(String key, Character value)
    {
        extras.addProperty(key, value);
    }

    public void putExtra(String key, JsonObject value)
    {
        extras.add(key, value);
    }

    public void putExtra(String key, JsonArray value)
    {
        extras.add(key, value);
    }


    public JsonObject getExtra(){
        return extras;
    }
}