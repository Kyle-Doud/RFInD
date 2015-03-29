package edu.auburn.rfid.rfind;
import java.util.ArrayList;
/**
 * Created by Kyle on 3/27/2015.
 */
public class UpcDescription {
    private String fit, style, color, vendor, size;
    private int upc;
    private ArrayList<Product> products;

    public UpcDescription(String fitIn, String styleIn, String colorIn, int upcIn, String vendorIn, String sizeIn)
    {
        this.fit = fitIn;
        this.style = styleIn;
        this. color = colorIn;
        this.vendor = vendorIn;
        this.size = sizeIn;
        this.upc = upcIn;
        products = new ArrayList<Product>();
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getUpc() {
        return upc;
    }

    public void setUpc(int upc) {
        this.upc = upc;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }


}
