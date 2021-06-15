package com.sliceeup.testjujura;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sliceeup.testjujura.adapter.ListProductAdapter;
import com.sliceeup.testjujura.adapter.ListSalesAdapter;
import com.sliceeup.testjujura.api.ApiClient;
import com.sliceeup.testjujura.api.ApiInterface;
import com.sliceeup.testjujura.model.Product;
import com.sliceeup.testjujura.model.Register;
import com.sliceeup.testjujura.model.RegisterPost;
import com.sliceeup.testjujura.model.Sales;
import com.sliceeup.testjujura.model.SalesList;
import com.sliceeup.testjujura.model.SalesListPost;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalesActivity extends AppCompatActivity {

    private RecyclerView rvSales;
    private ApiInterface mApiInterface;

    private final ArrayList<Sales > salesList = new ArrayList<>();

    private ArrayList<SalesList> listSalesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Sales");
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayShowHomeEnabled(true);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        TextView tvSignatureKey = findViewById(R.id.tv_signature_key);
        TextView tvPaymentType = findViewById(R.id.tv_payment_type);
        TextView tvCurrency = findViewById(R.id.tv_currency);
        TextView tvGrossAmount = findViewById(R.id.tv_gross_amount);

        //Dummy
        tvSignatureKey.setText("13895dffdefaf37aa6bad621b0d46418");
        tvPaymentType.setText("echannel");
        tvCurrency.setText("IDR");
        tvGrossAmount.setText("9600");


        rvSales = findViewById(R.id.rv_sales);
        rvSales.setHasFixedSize(true);

        Button btnSalesList = findViewById(R.id.btn_sales_list);
        btnSalesList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salesListIntent = new Intent(SalesActivity.this, SalesListActivity.class);
                startActivity(salesListIntent);

            }
        });



        showRecyclerList();

//        refresh();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    private void showRecyclerList(){
        //dummy
        salesList.add( new Sales( "01026B","2","180000","360000" ));
        salesList.add( new Sales( "02010L","3","100000","300000" ));
        salesList.add( new Sales( "02024L","1","150000","150000" ));
        salesList.add( new Sales( "332101","2","8000","16000" ));

        rvSales.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        ListSalesAdapter listSalesAdapter = new ListSalesAdapter(salesList);
        rvSales.setAdapter(listSalesAdapter);

        listSalesAdapter.setOnItemClickCallback(new ListSalesAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Sales data) {
                showSelectedSales(data);
            }
        });
    }

    private void showSelectedSales(Sales sales){

    }

}