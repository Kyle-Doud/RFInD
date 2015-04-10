package edu.auburn.rfid.rfind;

import java.util.ArrayList;

/**
 * Created by Robert on 10-Apr-15.
 */
public class RfidItems {
    private static RfidItems ourInstance = new RfidItems();

    public static RfidItems getInstance() {
        return ourInstance;
    }

    private RfidItems() {
        QueryManager request = new QueryManager();
        Rfid_Items = request.getFeaturedItems();
    }

    public void update() {
        QueryManager request = new QueryManager();
        Rfid_Items = request.getFeaturedItems();
    }

    public ArrayList<RfidItem> getItems() {
        return Rfid_Items;
    }

    private ArrayList<RfidItem> Rfid_Items = null;
}
