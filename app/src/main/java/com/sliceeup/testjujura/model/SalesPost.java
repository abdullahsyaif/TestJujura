package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class SalesPost {

    @SerializedName("signature_key")
    String signature_key;
    @SerializedName("payment_type")
    String payment_type;
    @SerializedName("gross_amount")
    String gross_amount;
    @SerializedName("currency")
    String currency;
    @SerializedName("items")
    ArrayList<Sales> listDataSales;

    public SalesPost() {
    }

    public SalesPost(String signature_key, String payment_type, String gross_amount, String currency, ArrayList<Sales> listDataSales) {
        this.signature_key = signature_key;
        this.payment_type = payment_type;
        this.gross_amount = gross_amount;
        this.currency = currency;
        this.listDataSales = listDataSales;
    }

    public String getSignature_key() {
        return signature_key;
    }

    public void setSignature_key(String signature_key) {
        this.signature_key = signature_key;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getGross_amount() {
        return gross_amount;
    }

    public void setGross_amount(String gross_amount) {
        this.gross_amount = gross_amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ArrayList<Sales> getListDataSales() {
        return listDataSales;
    }

    public void setListDataSales(ArrayList<Sales> listDataSales) {
        this.listDataSales = listDataSales;
    }
}
