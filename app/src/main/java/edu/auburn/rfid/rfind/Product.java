package edu.auburn.rfid.rfind;

/**
 * Created by Kyle on 3/27/2015.
 */
public class Product {
    public static final String IN_STORE = "in_store";
    public static final String IN_WAREHOUSE = "warehouse";
    private int serialNum, id;
    private String location;

    public Product(String locationIn, int serialNumIn, int idIn)
    {
        this.serialNum = serialNumIn;
        this.id = idIn;
        this.location = locationIn;
    }

    public int getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(int serialNum) {
        this.serialNum = serialNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
