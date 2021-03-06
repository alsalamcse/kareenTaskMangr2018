package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.owayed.kareen.kareentaskmangr2018.data.Animal;

public class DetailsOfAnimal extends AppCompatActivity {
    private TextView tvName,tvType,tvAge,tvColor,tvMoney,tvAddress;
    private Button btnRequest;
    private FirebaseAuth auth;
    private FirebaseUser user;

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
                Intent intent=new Intent(DetailsOfAnimal.this,MyPage.class);
                startActivity(intent);


            }
        });
        Request();

    }


    private void Request()
    {
        if (tvName.length() != 0 && tvAge.length() != 0 && tvColor.length() != 0&& tvMoney.length() != 0&& tvAddress.length() != 0) {
            auth = FirebaseAuth.getInstance();
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
            reference.child("Details").child(email.replace('.', '*')).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    DataSnapshot d = dataSnapshot.getChildren().iterator().next();
                    Animal p = d.getValue(Animal.class);
                    tvName.setText(p.getName());
                    tvAge.setText(p.getAge());
                    tvColor.setText(p.getColor());
                    tvMoney.setText(p.getMoney());
                    tvAddress.setText(p.getAddress());
                }


                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(getBaseContext(), "onCancelled", Toast.LENGTH_SHORT).show();

                }
            });

        }else {
            tvName.setError("Enter Name");
            tvType.setError("Enter Age");
            tvAge.setError("Enter Email");
            tvColor.setError("Enter Phone Number");
            tvAddress.setError("Enter Name");
            tvMoney.setError("Enter Age");
        }
    }

}
