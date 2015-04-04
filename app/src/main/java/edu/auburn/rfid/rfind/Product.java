package edu.auburn.rfid.rfind;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kyle on 3/27/2015.
 */
public class Product {
    public static final String IN_STORE = "in_store";
    public static final String IN_WAREHOUSE = "warehouse";
    private int serialNum, id;
    private String location;

    public Product(JSONObject jsonObject)
    {
        try {
            this.serialNum = jsonObject.getInt("serial_num");
            this.id = jsonObject.getInt("id");
            this.location = jsonObject.getString("location");
        }
        catch (JSONException e)
        {
            //do something graceful
        }
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
