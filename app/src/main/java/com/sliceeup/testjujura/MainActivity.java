package com.sliceeup.testjujura;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sliceeup.testjujura.api.ApiClient;
import com.sliceeup.testjujura.api.ApiInterface;
import com.sliceeup.testjujura.model.Product;
import com.sliceeup.testjujura.model.Register;
import com.sliceeup.testjujura.model.RegisterPost;
import com.sliceeup.testjujura.model.Sales;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EditText edUserName;
    private EditText edUserEmail;

    private ApiInterface mApiInterface;

    private String userName;
    private String userEmail;

    private ArrayList<Register> listRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Register");

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        edUserName = findViewById(R.id.ed_user_name);
        edUserEmail = findViewById(R.id.ed_email);

        Button btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });


    }


    public void validation(){
        userName = edUserName.getText().toString().trim();
        userEmail = edUserEmail.getText().toString().trim();

        boolean isEmptyFields = false;

        if (TextUtils.isEmpty(userName)){
            isEmptyFields = true;
            edUserName.setError("Field ini tidak boleh kosong");
        }

        if (TextUtils.isEmpty(userEmail)){
            isEmptyFields = true;
            edUserEmail.setError("Field ini tidak boleh kosong");
        }

        if (!isEmptyFields){
            save();
            Intent produtIntent = new Intent(MainActivity.this, ProductActivity.class);
            startActivity(produtIntent);
        }
    }

    private void save() {

        Register register = new Register(userName, userEmail);

        Call<RegisterPost> registerPostCall = mApiInterface.postRegister(register);
        registerPostCall.enqueue(new Callback<RegisterPost>() {
            @Override
            public void onResponse(Call<RegisterPost> call, Response<RegisterPost> response) {

                String signature_key = response.body().getSignature_key();
                Toast.makeText(MainActivity.this,"Signature Key = "  + signature_key, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<RegisterPost> call, Throwable t) {
            }
        });
    }
}