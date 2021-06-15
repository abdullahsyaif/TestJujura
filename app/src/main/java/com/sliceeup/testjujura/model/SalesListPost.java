package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SalesListPost {
    @SerializedName("http_code")
    String http_code;
    @SerializedName("items")
    ArrayList<SalesListItem> listDataListItems;
    @SerializedName("count")
    String count;

    public String getHttp_code() {
        return http_code;
    }

    public void setHttp_code(String http_code) {
        this.http_code = http_code;
    }

    public ArrayList<SalesListItem> getListDataListItems() {
        return listDataListItems;
    }

    public void setListDataListItems(ArrayList<SalesListItem> listDataListItems) {
        this.listDataListItems = listDataListItems;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
