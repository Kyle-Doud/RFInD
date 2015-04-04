package edu.auburn.rfid.rfind;

import android.util.Log;

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



    public RfidItem(JSONObject json)
    {
        upcDescription = new UpcDescription(json);
        products = new ArrayList<Product>();
        try
        {
            JSONArray productsArray = json.getJSONArray("products");
            for(int i = 0; i < productsArray.length(); i++)
            {
                Product product = new Product(productsArray.getJSONObject(i));
                products.add(product);
            }
        }
        catch(JSONException e)
        {
            //do something graceful
        }

    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public UpcDescription getUpcDescription() {
        return upcDescription;
    }

    public void setUpcDescription(UpcDescription upcDescription) {
        this.upcDescription = upcDescription;
    }


}
