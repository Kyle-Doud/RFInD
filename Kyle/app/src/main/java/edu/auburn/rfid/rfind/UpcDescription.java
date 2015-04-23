package edu.auburn.rfid.rfind;
import org.json.JSONException;
import org.json.JSONObject;
/**
 * Created by Kyle on 3/27/2015.
 */
public class UpcDescription {
    private String fit, style, color, vendor, size;
    private int upc;

    public UpcDescription(JSONObject jsonObject) {
        try {
            this.fit = jsonObject.getString("fit");
            this.style = jsonObject.getString("style");
            this.color = jsonObject.getString("color");
            this.upc = jsonObject.getInt("upc");
            this.vendor = jsonObject.getString("vendor");
            this.size = jsonObject.getString("size");
        }
        catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getFit() {
        return fit;
    }

    public String getStyle() {
        return style;
    }

    public String getColor() {
        return color;
    }

    public String getVendor() {
        return vendor;
    }

    public String getSize() {
        return size;
    }

    public int getUpc() {
        return upc;
    }


}
