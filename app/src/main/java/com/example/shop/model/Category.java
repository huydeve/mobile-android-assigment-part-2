package com.example.shop.model;

import java.io.Serializable;

public class Category implements Serializable {
    private String name;
    private int icon;

    public Category(String name ,int icon) {
        this.name = name;
        this.icon = icon;
    }



    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
