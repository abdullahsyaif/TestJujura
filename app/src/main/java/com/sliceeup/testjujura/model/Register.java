package com.sliceeup.testjujura.model;

import com.google.gson.annotations.SerializedName;

public class Register {

    @SerializedName("user_name")
    private String user_name;
    @SerializedName("user_email")
    private String user_email;

    public Register() {
    }

    public Register(String user_name, String user_email) {
        this.user_name = user_name;
        this.user_email = user_email;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
}
