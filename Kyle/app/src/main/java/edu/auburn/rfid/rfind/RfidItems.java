package edu.auburn.rfid.rfind;

import java.util.ArrayList;

/**
 * Created by Robert on 10-Apr-15.
 */
public class RfidItems {
    public enum RequestType {
        None,
        Query,
        Featured,
        Apparel,
        Department
    }

    private static RfidItems ourInstance = new RfidItems();

    public static RfidItems getInstance() {
        return ourInstance;
    }

    public ArrayList<RfidItem> getItems(RequestType type, String query) {
        switch (type) {
            case None:
                break;
            case Query:
                Rfid_Items = QueryManager.getRequestedItems(query);
                break;
            case Featured:
                Rfid_Items = QueryManager.getRequestedItems(query);
                break;
            case Department:
                break;
            case Apparel:
                break;
        }
        return Rfid_Items;
    }

    private ArrayList<RfidItem> Rfid_Items = QueryManager.getRequestedItems("");
}
