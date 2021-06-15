package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

public class SalesListItem {

    @SerializedName("sales_id")
    private String sales_id;
    @SerializedName("signature_key")
    private String signature_key;
    @SerializedName("payment_type")
    private String payment_type;
    @SerializedName("gross_amount")
    private String gross_amount;
    @SerializedName("currency")
    private String currency;
    @SerializedName("sales_status")
    private String sales_status;
    @SerializedName("created")
    private String created;

    public SalesListItem(String sales_id, String signature_key, String payment_type, String gross_amount, String currency, String sales_status, String created) {
        this.sales_id = sales_id;
        this.signature_key = signature_key;
        this.payment_type = payment_type;
        this.gross_amount = gross_amount;
        this.currency = currency;
        this.sales_status = sales_status;
        this.created = created;
    }

    public SalesListItem() {
    }

    public String getSales_id() {
        return sales_id;
    }

    public void setSales_id(String sales_id) {
        this.sales_id = sales_id;
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

    public String getSales_status() {
        return sales_status;
    }

    public void setSales_status(String sales_status) {
        this.sales_status = sales_status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
