package edu.auburn.rfid.rfind.item;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class RfidItem {
    public class UpcDescription {
        public String Fit, Style, Color, Vendor, Size;
        public int UPC;
        public ArrayList<Product> Products = new ArrayList<>();
        public ArrayList<String> Locations = new ArrayList<>();

        public UpcDescription(JSONObject jsonObject) {
            try {
                Fit = jsonObject.getString("fit");
                Style = jsonObject.getString("style");
                Color = jsonObject.getString("color");
                UPC = jsonObject.getInt("upc");
                Vendor = jsonObject.getString("vendor");
                Size = jsonObject.getString("size");

                JSONArray productsArray = jsonObject.getJSONArray("products");
                for(int i = 0; i < productsArray.length(); i++) {
                    Product product = new Product(productsArray.getJSONObject(i));
                    Products.add(product);
                    Locations.add(product.Location);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public class Product {
        public int Serial_Number, ID;
        private String Location;

        public Product(JSONObject jsonObject) {
            try {
                Serial_Number = jsonObject.getInt("serial_num");
                ID = jsonObject.getInt("id");
                Location = jsonObject.getString("location");
            }
            catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public enum RequestType {
        None,
        Query,
        Featured,
        Apparel,
        Department,
    }

    public UpcDescription UPCDescription;

    public RfidItem(JSONObject json) {
        UPCDescription = new UpcDescription(json);
        createContent();
    }

    private void createContent() {
        Content = "Vendor:\t" + UPCDescription.Vendor + "\n"
                +  "Style:\t" + UPCDescription.Style + "\n"
                +  "Fit:\t" + UPCDescription.Fit + "\n"
                +  "Size:\t" + UPCDescription.Size + "\n"
                +  "Color:\t" + UPCDescription.Color + "\n";
    }


    public static HashMap<String, RfidItem> Item_Map = new HashMap<>();
    public String Content;
}
