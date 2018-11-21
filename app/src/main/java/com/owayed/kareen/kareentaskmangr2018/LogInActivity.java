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

public class LogInActivity extends AppCompatActivity {
               private EditText et1,et2;
               private Button btn1,btn2;
               private FirebaseAuth auth;

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
                           dataHandler();

                           btn2.setOnClickListener(new View.OnClickListener() {
                               @Override
                               public void onClick(View view) {
                                   Intent i2=new Intent(LogInActivity.this,MainTapsActivity.class);
                                   startActivity(i2);
                               }
                           });
                       }

                       private void dataHandler() {

                           boolean isok = true;
                           String email = et1.getText().toString();
                           String password = et2.getText().toString();
                           signIn(email,password);
                           if (email.length() < 4 || email.indexOf('@') < 0 || email.indexOf('.') < 0) {
                               et1.setError("Wrong Email");
                               isok = false;
                           }
                           if (password.length() < 8) {
                               et2.setError("Have to be at least 8 char");
                               isok = false;
                           }
                           }
                           private void signIn(String email,String passw){
                           auth=FirebaseAuth.getInstance();
                               auth.signInWithEmailAndPassword(email, passw).addOnCompleteListener(LogInActivity.this, new OnCompleteListener<AuthResult>() {
                               @Override
                               public void onComplete(@NonNull Task<AuthResult> task) {
                                   if (task.isSuccessful())
                                   {
                                       Toast.makeText(LogInActivity.this,"signIn Successful",Toast.LENGTH_SHORT).show();
                                       Intent intent=new Intent(LogInActivity.this,MainTapsActivity.class);
                                       startActivity(intent);
                               }
                               else
                                   {
                                       Toast.makeText(LogInActivity.this,"LogIn faild"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                                   }
                           }


                           });




                           }

                   });
    }


}
