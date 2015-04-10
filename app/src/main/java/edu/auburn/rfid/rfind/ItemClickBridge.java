package edu.auburn.rfid.rfind;

/**
 * Created by Robert on 08-Apr-15.
 */
public class ItemClickBridge {
    public static void setCurrentItem(Object item) {
        Item = item;
    }

    public static Object getCurrentItem() {
        return Item;
    }

    private static Object Item = null;
}
