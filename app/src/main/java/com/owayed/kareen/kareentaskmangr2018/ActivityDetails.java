package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.owayed.kareen.kareentaskmangr2018.data.Animal;
import com.owayed.kareen.kareentaskmangr2018.data.MyProfile;

public class ActivityDetails extends AppCompatActivity {
    private EditText etNameDonor,etEmailDonor, etNumberDonor;
    private Animal animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_of_details);
        etEmailDonor=findViewById(R.id.etEmailDonor);
        etNameDonor=findViewById(R.id.etNameDonor);
        etNumberDonor=findViewById(R.id.etNumberDonor);

getProfile();
        Intent i=getIntent();
        if (i!=null&&i.hasExtra("animal"))
        {
            animal= (Animal) i.getExtras().get("animal");
        }



    }
    private final void getProfile()
    {
        if (etNameDonor.length() != 0 && etNumberDonor.length() != 0 && etEmailDonor.length() != 0) {


            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            String key = reference.child("MyProfile").push().getKey();
            String email=FirebaseAuth.getInstance().getCurrentUser().getEmail();
            reference.child("MyProfile").child(email.replace('.','*')).addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    // DataSnapshot d=dataSnapshot.getChildren().iterator().next();
                    MyProfile p = dataSnapshot.getValue(MyProfile.class);
                    etNameDonor.setText(p.getName());
                    etNumberDonor.setText(p.getAge());
                    etEmailDonor.setText(p.getEmail());


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(getBaseContext(), "onCancelled", Toast.LENGTH_SHORT).show();
                }
            });


        } else {
            etNameDonor.setError("Enter Name");
            etNumberDonor.setError("Enter Number");
            etEmailDonor.setError("Enter Email");

        }
    }
}








