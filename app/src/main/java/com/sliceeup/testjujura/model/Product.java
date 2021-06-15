package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("product_id")
    private String product_id;
    @SerializedName("name")
    private String name;
    @SerializedName("price")
    private String price;
    @SerializedName("stock")
    private String stock;

    public Product() {
    }

    public Product(String product_id, String name, String price, String stock) {
        this.product_id = product_id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
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

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}
