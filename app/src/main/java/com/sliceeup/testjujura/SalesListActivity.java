package com.sliceeup.testjujura;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sliceeup.testjujura.api.ApiClient;
import com.sliceeup.testjujura.api.ApiInterface;
import com.sliceeup.testjujura.model.Sales;
import com.sliceeup.testjujura.model.SalesList;
import com.sliceeup.testjujura.model.SalesListItem;
import com.sliceeup.testjujura.model.SalesListPost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalesListActivity extends AppCompatActivity {

    private ApiInterface mApiInterface;

    TextView tvSalesID;
    TextView tvSignatureKey;
    TextView tvPaymentType;
    TextView tvCurrency;
    TextView tvGrossAmount;
    TextView tvSalesStatus;
    TextView tvCreated;

    private ArrayList<SalesListItem> salesListItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_list);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Sales List");

        tvSalesID = findViewById(R.id.tv_sales_id);
        tvSignatureKey = findViewById(R.id.tv_signature_key);
        tvPaymentType = findViewById(R.id.tv_payment_type);
        tvCurrency = findViewById(R.id.tv_currency);
        tvGrossAmount = findViewById(R.id.tv_gross_amount);
        tvSalesStatus = findViewById(R.id.tv_sales_status);
        tvCreated = findViewById(R.id.tv_created);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        Button btnHome = findViewById(R.id.btn_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent homeIntent = new Intent(SalesListActivity.this, ProductActivity.class);
                startActivity(homeIntent);
            }
        });

        getSalesList();
    }

    private void getSalesList() {

        //dummy
        String signature_key = "13895dffdefaf37aa6bad621b0d46418";

        SalesList salesList = new SalesList(signature_key);

        Call<SalesListPost> salesListPostCall = mApiInterface.postSalesList(salesList);
        salesListPostCall.enqueue(new Callback<SalesListPost>() {
            @Override
            public void onResponse(Call<SalesListPost> call, Response<SalesListPost> response) {

                salesListItems = response.body().getListDataListItems();

                tvSalesID.setText(salesListItems.get(0).getSales_id());
                tvSignatureKey.setText(salesListItems.get(0).getSignature_key());
                tvPaymentType.setText(salesListItems.get(0).getPayment_type());
                tvCurrency.setText(salesListItems.get(0).getCurrency());
                tvGrossAmount.setText(salesListItems.get(0).getGross_amount());
                tvSalesStatus.setText(salesListItems.get(0).getSales_status());
                tvCreated.setText(salesListItems.get(0).getCreated());
            }

            @Override
            public void onFailure(Call<SalesListPost> call, Throwable t) {

            }
        });
    }

}