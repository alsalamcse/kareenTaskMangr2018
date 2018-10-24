package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTitle,etText,etDate;
    private TextView tvImportant,tvNecessary;
    private SeekBar skbrImportant,skbrNecessary;
    private Button btSave,btnDatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        etTitle = findViewById(R.id.etTitle);
        etText = findViewById(R.id.etText);
        tvImportant = findViewById(R.id.tvImportant);
        tvNecessary = findViewById(R.id.tvNecessary);
        skbrImportant = findViewById(R.id.skbrImportant);
        skbrNecessary = findViewById(R.id.skbrNecessary);
        etDate = findViewById(R.id.etDate);

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddTaskActivity.this, MainTapsActivity.class);
                startActivity(intent);

            }
        });
        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(AddTaskActivity.this, LogInActivity.class);
                startActivity(i2);

            }
        });
    }
}
