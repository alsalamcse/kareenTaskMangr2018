package com.owayed.kareen.kareentaskmangr2018;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity {
    private EditText etTitle,etText,etDate;
    private TextView tvImportant,tvNecessary;
    private SeekBar skbrImportant,skbrNecessary;
    private Button btSave,btnDatePicker;
    private int mYear,mMonth,mDay;

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

                dataHandler();

            }
        });
    }
    private void dataHandler(){

        boolean isok = true;
        String title= etTitle.getText().toString();
        String text = etText.getText().toString();
        String date = etDate.getText().toString();
        String important=tvImportant.getText().toString();
        String necessary=tvNecessary.getText().toString();

        if (title.length() < 4 || title.indexOf('@') < 0 || title.indexOf('.') < 0) {
            etTitle.setError("Wrong Email");
            isok = false;
        }
        if (text.length() < 8) {
           etText.setError("Have to be at least 8 char");
            isok = false;
        }

    }
    public void onClick(View view){
        if (view==btnDatePicker){
            final Calendar c=Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
            mDay=c.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int dayOfMonth, int monthOfYear, int year) {
                    etDate.setText(dayOfMonth+"-"+(monthOfYear+1)+"-"+year);

                }
            },
                    mYear,mMonth,mDay);
            datePickerDialog.show();
        }

    }


}
