package com.robert.myapplication.network;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @author Robert
 * @date 20-Apr-15.
 */
public class VolleyRequest {
    private static VolleyRequest Instance;
    private static Context App_Context;
    private RequestQueue Queue;

    private VolleyRequest(Context context) {
        App_Context = context;
        Queue = getRequestQueue();
    }

    public static synchronized VolleyRequest getInstance(Context context) {
        if (Instance == null) {
            Instance = new VolleyRequest(context);
        }
        return Instance;
    }

    public RequestQueue getRequestQueue() {
        if (Queue == null) {
            Queue = Volley.newRequestQueue(App_Context.getApplicationContext());
        }
        return Queue;
    }

    public <T> void addToRequestQueue(Request<T> request) {
        getRequestQueue().add(request);
    }
}

