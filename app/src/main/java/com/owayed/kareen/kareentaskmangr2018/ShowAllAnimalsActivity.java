package com.owayed.kareen.kareentaskmangr2018;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.owayed.kareen.kareentaskmangr2018.data.Animal;
import com.owayed.kareen.kareentaskmangr2018.data.AnimalAdopter;

public class ShowAllAnimalsActivity extends AppCompatActivity {
    private ListView IvAnimal;
    private AnimalAdopter animalAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_tasks);
        IvAnimal=findViewById(R.id.lstv);
        animalAdopter=new AnimalAdopter(getBaseContext(),R.layout.animalitem);
        IvAnimal.setAdapter(animalAdopter);
        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.SEND_SMS)) {
            } else {
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.SEND_SMS},
                        100);
            }
        }
        readAnimal();


    }
    private void readAnimal()
    {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        reference.child("MyAnimals").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Toast.makeText(getBaseContext(),"data changed",Toast.LENGTH_SHORT).show();
                animalAdopter.clear();
                for (DataSnapshot d:dataSnapshot.getChildren())
                {
                    Animal animal=d.getValue(Animal.class);
                    animalAdopter.add(animal);
                }
                animalAdopter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {
                Toast.makeText(getBaseContext(),"onCancelled",Toast.LENGTH_SHORT).show();

            }
        });
    }




    @Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 100: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Toast.makeText(getApplicationContext(), "SMS OK.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
        }

    }
}
