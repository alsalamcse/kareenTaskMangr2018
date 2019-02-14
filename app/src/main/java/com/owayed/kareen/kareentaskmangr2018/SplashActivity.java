package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplashActivity extends AppCompatActivity {
    private Button btnEntering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        btnEntering=findViewById(R.id.btnEntering);
        btnEntering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SplashActivity.this,LogInActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onResume() {
        MyThread myThread=new MyThread();
        myThread.start();
        super.onResume();
    }

    public class MyThread extends Thread
    {
        @Override
        public void run() {
            try {
                sleep(3000);
                Intent i=new Intent(SplashActivity.this,LogInActivity.class);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}



