package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.owayed.kareen.kareentaskmangr2018.datePicker.AddAnimal;
import com.owayed.kareen.kareentaskmangr2018.datePicker.MyTask;

public class DetailsOfAnimal extends AppCompatActivity {
    private EditText etType,etAge,etColor,etMoney,etAddress;
    private Button btnSave;
    private ImageButton ibPicture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_of_animal);
        etType = findViewById(R.id.etType);
        etAge = findViewById(R.id.etAge);
        etColor = findViewById(R.id.etColor);
        etMoney = findViewById(R.id.etMoney);
        ibPicture=findViewById(R.id.ibPicture);
        etAddress=findViewById(R.id.etAddress);
        btnSave=findViewById(R.id.btnSave);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(DetailsOfAnimal.this,MainTapsActivity.class);
                startActivity(i);

                dataHandler();

            }
        });
    }
    private void dataHandler(){

        boolean isok = true;
        String Type= etType.getText().toString();
        String Color = etColor.getText().toString();
        String Address = etAddress.getText().toString();
        String Age=etAge.getText().toString();
        String Money=etMoney.getText().toString();


        if (Type.length() ==0) {
            etType.setError("Type can not be empty");
            isok = false;
        }
        if (Color.length()==0) {
           etColor.setError("Color can not to be empty");
            isok = false;
        }
        if (Address.length()==0) {
            etAddress.setError("Address can not to be empty");
            isok = false;
        }
        if (Age.length()==0) {
            etAge.setError("Age can not to be empty");
            isok = false;
        }
        if (Money.length()==0) {
            etMoney.setError("Money can not to be empty");
            isok = false;
        }
        if (isok){

            MyTask task=new MyTask();
            AddAnimal animal= new AddAnimal();

            animal.setType(Type);
            animal.setColor(Color);


            FirebaseAuth auth=FirebaseAuth.getInstance();
            task.setOwner(auth.getCurrentUser().getEmail());

            DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
            String key=reference.child("MyTask").push().getKey();
            task.setKey(key);
            reference.child("MyTask").child(key).setValue(task).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task)
                {
                    if (task.isSuccessful())
                    {
                        Toast.makeText(DetailsOfAnimal.this,"add Successful",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(DetailsOfAnimal.this,"add failes",Toast.LENGTH_LONG).show();

                    }
                }
            });
        }


        }




}
