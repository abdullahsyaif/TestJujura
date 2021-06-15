package com.sliceeup.testjujura;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.sliceeup.testjujura.adapter.ListProductAdapter;
import com.sliceeup.testjujura.api.ApiClient;
import com.sliceeup.testjujura.api.ApiInterface;
import com.sliceeup.testjujura.model.Product;
import com.sliceeup.testjujura.model.ProductGet;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductActivity extends AppCompatActivity {

    public static final String EXTRA_PRODUCT_ID = "extra_product_id";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_PRICE = "extra_price";
    public static final String EXTRA_STOCK = "extra_stock";

    private RecyclerView rvProduct;
    private ApiInterface mApiInterface;
    private ArrayList<Product> productList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Product");

        rvProduct = findViewById(R.id.rv_product);
        rvProduct.setHasFixedSize(true);

        Button btnSales = findViewById(R.id.btn_sales);
        btnSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salesIntent = new Intent(ProductActivity.this, SalesActivity.class);
                startActivity(salesIntent);
            }
        });

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        showRecyclerList();

        refresh();
    }

    private void refresh(){
        Call<ProductGet> productGetCall = mApiInterface.getProduct();
        productGetCall.enqueue(new Callback<ProductGet>() {
            @Override
            public void onResponse(Call<ProductGet> call, Response<ProductGet> response) {
                productList = response.body().getListDataProducts();
                Log.d("Retrofit Get", "Jumlah data produk: " + productList.size());
                showRecyclerList();
            }

            @Override
            public void onFailure(Call<ProductGet> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }


    private void showRecyclerList(){
        rvProduct.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ListProductAdapter listProductAdapter = new ListProductAdapter(productList);
        rvProduct.setAdapter(listProductAdapter);

        listProductAdapter.setOnItemClickCallback(new ListProductAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Product data) {
                showSelectedProduct(data);
            }
        });
    }

    private void showSelectedProduct(Product product){

        Intent salesIntent = new Intent(ProductActivity.this, DetailProductActivity.class);
        salesIntent.putExtra(ProductActivity.EXTRA_PRODUCT_ID, product.getProduct_id());
        salesIntent.putExtra(ProductActivity.EXTRA_NAME, product.getName());
        salesIntent.putExtra(ProductActivity.EXTRA_PRICE, product.getPrice());
        salesIntent.putExtra(ProductActivity.EXTRA_STOCK, product.getStock());
        startActivity(salesIntent);
    }
}