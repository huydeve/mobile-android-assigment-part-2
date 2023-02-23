package com.example.shop.entity;

import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
public class Category implements Serializable {
    @PrimaryKey
    private int id;
    private String name;
    private int icon;

    private String phone;

    public Category(String name ,int icon, String phone) {
        this.name = name;
        this.icon = icon;
        this.phone = phone;
    }


    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public int getIcon() {
        return icon;
    }
}
