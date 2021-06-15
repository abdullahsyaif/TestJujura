package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

public class SalesList {

    @SerializedName("signature_key")
    private String signature_key;

    public SalesList() {
    }

    public SalesList(String signature_key) {
        this.signature_key = signature_key;
    }

    public String getSignature_key() {
        return signature_key;
    }

    public void setSignature_key(String signature_key) {
        this.signature_key = signature_key;
    }
}
