package com.example.shop.entity;

import android.arch.persistence.room.ColumnInfo;


import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity
public class Product{
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int mId;
    @ColumnInfo(name = "name")
    private String mName;
    @ColumnInfo(name = "description")
    private String mDescription;
    @ColumnInfo(name = "price")
    private int mPrice;

    public Product() {
    }

    public Product(int mId, String mName, String mDescription, int mPrice) {
        this.mId = mId;
        this.mName = mName;
        this.mDescription = mDescription;
        this.mPrice = mPrice;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        mPrice = price;
    }
}
