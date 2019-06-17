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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.owayed.kareen.kareentaskmangr2018.data.MyProfile;

public class SignUpActivity extends AppCompatActivity {

    FirebaseAuth auth; //to establish sign in sign up
    FirebaseUser user; // user
    private EditText et1,et2,et3,et4,et5,etAge;
    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();// btrj3 ka2en

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        et3 = findViewById(R.id.et3);
        et4 = findViewById(R.id.et4);
        et5 = findViewById(R.id.et5);
        etAge=findViewById(R.id.etAge);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                dataHandler();


            }
        });


    }

    private void dataHandler() {

        boolean isok = true;

        String email = et4.getText().toString();
        String password = et5.getText().toString();
        String fname = et1.getText().toString();
        String phone = et3.getText().toString();
        String Age=etAge.getText().toString();

        if (email.length() ==0) {
            et4.setError("Name can not be empty");
            isok = false;
        }

        if (fname.length() ==0) {
            et1.setError("Type can not be empty");
            isok = false;
        }
        if (phone.length()==0) {
            et3.setError("Color can not to be empty");
            isok = false;
        }
        if (Age.length()==0) {
            etAge.setError("Color can not to be empty");
            isok = false;
        }

        if (email.length() < 4 || email.indexOf('@') < 0 || email.indexOf('.') < 0) {
            et4.setError("Wrong Email");
            isok = false;
        }
        if (password.length() < 8) {
            et5.setError("Have to be at least 8 char");
            isok = false;
        }
        if (isok) {

                creatAcount(email, password);


        }

    }




        private void creatAcount(String email, String password)
        {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "Authentication successful", Toast.LENGTH_SHORT).show();

                    profiledatahandler();
                } else {
                    Toast.makeText(SignUpActivity.this, "Authenication faild" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    task.getException().printStackTrace();
                }
            }
        });
    }


    private void profiledatahandler() {
        boolean isok = true;
        String email = et4.getText().toString();
        String fname = et1.getText().toString();
        String phone = et3.getText().toString();
        String Age=etAge.getText().toString();

        MyProfile myProfile=new MyProfile();


            myProfile.setName(fname);
            myProfile.setEmail(email);
            myProfile.setPhoneNumber(phone);
            myProfile.setAge(Age);

        FirebaseAuth auth=FirebaseAuth.getInstance();
        myProfile.setEmail(email);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        myProfile.setKey(email);
        reference.child("MyProfile").child(email.replace('.','*')).setValue(myProfile).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task)
            {
                if (task.isSuccessful())
                {
                    Toast.makeText(getBaseContext(),"add Successful",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(getBaseContext(),LogInActivity.class);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getBaseContext(),"add failed",Toast.LENGTH_LONG).show();

                }
            }
        });
    }


    }


