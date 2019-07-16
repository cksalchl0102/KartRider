package com.choichanmi.computer.kartrider;

import android.graphics.drawable.Drawable;

public class MyProductList {
    private String name;
    private String price;
    private String capacity;
    private String country;
    public  MyProductList(String name, String price,String capacity,String country){
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
