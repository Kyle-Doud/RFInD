package edu.auburn.rfid.rfind;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Kyle on 3/28/2015.
 */
public class RfidItem {
    private UpcDescription upcDescription;
    private ArrayList<Product> products;

    public RfidItem(JSONObject json) {
        upcDescription = new UpcDescription(json);
        products = new ArrayList<>();
        try {
            JSONArray productsArray = json.getJSONArray("products");
            for(int i = 0; i < productsArray.length(); i++) {
                Product product = new Product(productsArray.getJSONObject(i));
                products.add(product);
            }
        }
        catch(JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public UpcDescription getUpcDescription() {
        return upcDescription;
    }
}
