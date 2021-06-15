package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

public class RegisterPost {

    @SerializedName("http_code")
    String http_code;
    @SerializedName("signature_key")
    String signature_key;
    @SerializedName("message")
    String message;

    public String getHttp_code() {
        return http_code;
    }

    public void setHttp_code(String http_code) {
        this.http_code = http_code;
    }

    public String getSignature_key() {
        return signature_key;
    }

    public void setSignature_key(String signature_key) {
        this.signature_key = signature_key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
