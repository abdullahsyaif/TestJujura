package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

public class Sales {

    @SerializedName("item_id")
    private String item_id;
    @SerializedName("qty")
    private String qty;
    @SerializedName("price")
    private String price;
    @SerializedName("total")
    private String total;

    public Sales() {
    }

    public Sales(String item_id, String qty, String price, String total) {
        this.item_id = item_id;
        this.qty = qty;
        this.price = price;
        this.total = total;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getQty() {
        return qty;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
