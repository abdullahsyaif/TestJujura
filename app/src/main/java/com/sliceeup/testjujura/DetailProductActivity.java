package com.sliceeup.testjujura;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Product Detail");
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        String product_id = getIntent().getStringExtra(ProductActivity.EXTRA_PRODUCT_ID);
        String name = getIntent().getStringExtra(ProductActivity.EXTRA_NAME);
        String price = getIntent().getStringExtra(ProductActivity.EXTRA_PRICE);
        String stock = getIntent().getStringExtra(ProductActivity.EXTRA_STOCK);

        TextView tvProductID = findViewById(R.id.tv_product_id);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvPrice = findViewById(R.id.tv_price);
        TextView tvStock = findViewById(R.id.tv_stock);
        tvProductID.setText(product_id);
        tvName.setText(name);
        tvPrice.setText(price);
        tvStock.setText(stock);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}