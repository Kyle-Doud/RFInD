package com.robert.myapplication.network;

import com.robert.myapplication.item.RfidItem;

import java.io.IOException;

/**
 * @author Robert
 * @date 20-Apr-15.
 */
public class Request {
    private static final String Host_Address = "http://aurfid.herokuapp.com/upc_descriptions.json";

    private static void pingServerForWakeUp() {
        try {
            Process process = Runtime.getRuntime().exec("ping -4w 10000" + Host_Address);
            process.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String createAddress(RfidItem.RequestType type) {
        pingServerForWakeUp();
        return Host_Address + createCategoryAddress(type);
    }

    public static String createAddress(String query) {
        pingServerForWakeUp();
        return Host_Address + "?utf8=✓&search=" + query.toLowerCase();
    }

    private static String createCategoryAddress(RfidItem.RequestType type) {
        switch (type) {
            case Apparel:
                return "";
            case Featured:
                return "";
            default:
                return "";
        }
    }
}
