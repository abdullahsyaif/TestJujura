package com.sliceeup.testjujura.api;

import com.google.gson.annotations.Expose;
import com.sliceeup.testjujura.model.Product;
import com.sliceeup.testjujura.model.ProductGet;
import com.sliceeup.testjujura.model.Register;
import com.sliceeup.testjujura.model.RegisterPost;
import com.sliceeup.testjujura.model.SalesList;
import com.sliceeup.testjujura.model.SalesListPost;
import com.sliceeup.testjujura.model.SalesPost;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("Register")
    Call<RegisterPost> postRegister(@Body Register register);

    @POST("Sales/Insert")
    Call<SalesPost> postSales(@Body SalesPost salesPost);

    @POST("Sales")
    Call<SalesListPost> postSalesList(@Body SalesList salesList);

    @GET("Product")
    Call<ProductGet> getProduct();



}
