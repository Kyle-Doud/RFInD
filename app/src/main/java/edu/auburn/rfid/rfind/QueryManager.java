package edu.auburn.rfid.rfind;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Kyle on 4/3/2015.
 */
public class QueryManager {

    private static final String Host_Address = "http://aurfid.herokuapp.com/";
    private static final String JSON = ".json";

    private static void pingServerForWakeUp() {
        try {
            Process process = Runtime.getRuntime().exec("ping -4w 10000" + Host_Address);
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<RfidItem> getRequestedItems(String query) {
        final ArrayList<RfidItem> resultant_list = new ArrayList<>();
        pingServerForWakeUp();
        String request_address;
        if (query.equals("")) {
            request_address = Host_Address + "upc_descriptions" + JSON;
        } else {
            request_address = Host_Address + "upc_descriptions?utf8=✓&search=" + query;
        }
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                request_address,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray upcDescriptions = response.getJSONArray("upc_descriptions");
                            for(int i = 0; i < upcDescriptions.length(); i++) {
                                RfidItem rfidItem = new RfidItem(upcDescriptions.getJSONObject(i));
                                resultant_list.add(rfidItem);
                            }

                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        VolleyApplication.getInstance().getRequestQueue().add(request);
        return resultant_list;
    }
}
