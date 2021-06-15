package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

public class SalesReturn {

    @SerializedName("http_code")
    String http_code;
    @SerializedName("sales_id")
    String sales_id;
    @SerializedName("message")
    String message;

    public String getHttp_code() {
        return http_code;
    }

    public void setHttp_code(String http_code) {
        this.http_code = http_code;
    }

    public String getSales_id() {
        return sales_id;
    }

    public void setSales_id(String sales_id) {
        this.sales_id = sales_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
