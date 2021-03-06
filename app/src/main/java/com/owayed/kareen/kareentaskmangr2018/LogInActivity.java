package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LogInActivity extends AppCompatActivity {
    private EditText et1, et2;
    private Button btn1, btnAdopter, btnowner;
    private FirebaseAuth auth;
    private FirebaseUser user;
    private boolean isOwner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null && auth.getCurrentUser().getEmail() != null) {
            Intent intent = new Intent(LogInActivity.this, MainTapsActivity.class);
            startActivity(intent);
        }

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        btn1 = findViewById(R.id.btn1);
        btnowner = findViewById(R.id.btnOwner);
        btnAdopter = findViewById(R.id.btnAdopter);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);


            }
        });
        btnAdopter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                isOwner = false;
                dataHandler();
//                Intent i2=new Intent(LogInActivity.this,MyPage.class);
//                startActivity(i2);

            }
        });
        btnowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isOwner = true;
                dataHandler();
            }
        });
    }


    private void dataHandler() {

        boolean isok = true;
        String email = et1.getText().toString();
        String passw = et2.getText().toString();
        if (email == null || email.length() < 4 || email.indexOf('@') < 0 || email.indexOf('.') < 0) {
            et1.setError("Wrong Email");
            isok = false;
        }
        if (passw == null || passw.length() < 8) {
            et2.setError("wrong password");
            isok = false;
        }
        if (isok) {
            signIn(email, passw);
        }

    }

    private void signIn(String email, String passw) {
        auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LogInActivity.this, "signIn Successful", Toast.LENGTH_SHORT).show();
                    finish();
                    if (isOwner == false) {
                        Intent intent = new Intent(LogInActivity.this, MyPage.class);
                        startActivity(intent);

                    }
                    if (isOwner == true) {

                        Intent i = new Intent(LogInActivity.this, MainTapsActivity.class);
                        startActivity(i);

                    }


                }else {
                    Toast.makeText(LogInActivity.this, "LogIn faild" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
                }



        });


    }


}
