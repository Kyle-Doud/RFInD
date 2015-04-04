package edu.auburn.rfid.rfind;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
/**
 * Created by Kyle on 3/27/2015.
 */
public class UpcDescription {
    private String fit, style, color, vendor, size;
    private int upc;

    public UpcDescription(JSONObject jsonObject)
    {
        try {
            this.fit = jsonObject.getString("fit");
            this.style = jsonObject.getString("style");
            this.color = jsonObject.getString("color");
            this.upc = jsonObject.getInt("upc");
            this.vendor = jsonObject.getString("vendor");
            this.size = jsonObject.getString("size");
        }
        catch (JSONException e) {
            //do something graceful
        }
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getUpc() {
        return upc;
    }
    public void setUpc(int upc) {
        this.upc = upc;
    }


}
