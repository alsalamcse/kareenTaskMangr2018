package com.owayed.kareen.kareentaskmangr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddAnimalActivity extends AppCompatActivity {
    private EditText etType,etAge,etColor,etAddress,etMoney;
    private Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_animal);
        etType=findViewById(R.id.etType);
        etAge=findViewById(R.id.etAge);
        etColor=findViewById(R.id.etColor);
        etAddress=findViewById(R.id.etAddress);
        etMoney=findViewById(R.id.etMoney);
        btnSave=findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


    }
}
