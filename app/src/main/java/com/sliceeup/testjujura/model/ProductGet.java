package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProductGet {

    @SerializedName("status")
    String status;
    @SerializedName("items")
    ArrayList<Product> listDataProducts;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Product> getListDataProducts() {
        return listDataProducts;
    }

    public void setListDataCategory(ArrayList<Product> listDataCategory) {
        this.listDataProducts = listDataCategory;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
