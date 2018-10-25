package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {
    private EditText et1,et2;
    private Button btn1,btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        et1=findViewById(R.id.et1);
        et2=findViewById(R.id.et2);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
       btn1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(LogInActivity.this,MainTapsActivity.class);
               startActivity(i);
               Intent intent=new Intent(LogInActivity.this,SignUpActivity.class);
               startActivity(intent);
btn2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent i2=new Intent(LogInActivity.this,MainTapsActivity.class);
        startActivity(i2);
    }
});
           }
       });
    }
}
