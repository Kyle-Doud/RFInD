package edu.auburn.rfid.rfind;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kyle on 3/27/2015.
 */
public class Product {
    private int serialNum, id;
    private String location;

    public Product(JSONObject jsonObject) {
        try {
            this.serialNum = jsonObject.getInt("serial_num");
            this.id = jsonObject.getInt("id");
            this.location = jsonObject.getString("location");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getSerialNum() {
        return serialNum;
    }

    public int getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }
}
