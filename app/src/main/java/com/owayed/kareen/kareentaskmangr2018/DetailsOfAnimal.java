package com.owayed.kareen.kareentaskmangr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailsOfAnimal extends AppCompatActivity {
    private TextView tvName,tvType,tvAge,tvColor,tvMoney,tvAddress;
    private Button btnRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_animal);
        tvName=findViewById(R.id.tvName);
        tvType=findViewById(R.id.tvType);
        tvAge=findViewById(R.id.tvAge);
        tvColor=findViewById(R.id.tvColor);
        tvMoney=findViewById(R.id.tvMoney);
        tvName=findViewById(R.id.tvName);
        tvAddress=findViewById(R.id.tvAddress);
        btnRequest=findViewById(R.id.btnRequest);

        btnRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
