package edu.auburn.rfid.rfind;

import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Kyle on 4/17/2015.
 */
public class ProductTest extends TestCase {
    public static final String PRODUCTS = "\"products\":[{\"id\":\"1\",\"serial_num\":\"1\",\"location\":\"in_store\"}]";
    public static final String UPC = "\"upc\":\"51071851756\",\"vendor\":\"Wrangler\",\"size\":\"50/30\",\"fit\":\"Stretch Extensible\",\"style\":\"jeans\",\"color\":\"blue\"";
    public void testCreateProductValidInput()
    {
        try {
            JSONObject jo = new JSONObject("{\"upc_descriptions\":[{" + UPC + "," + PRODUCTS + "}]}");

        } catch (JSONException e)
        {
            e.printStackTrace();
        }
    }
}
