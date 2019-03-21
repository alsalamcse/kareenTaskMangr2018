package com.owayed.kareen.kareentaskmangr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.owayed.kareen.kareentaskmangr2018.datePicker.Animal;
import com.owayed.kareen.kareentaskmangr2018.datePicker.AnimalAdopter;

public class SearchActivity extends AppCompatActivity {
    private Button btnSearch;
    private EditText etSearch;
    private ListView LsId;
 AnimalAdopter adopter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        btnSearch=findViewById(R.id.btnSearch);
        etSearch=findViewById(R.id.etSearch);
        LsId=findViewById(R.id.LsId);

        adopter=new AnimalAdopter(getBaseContext(),R.layout.animalitem);
        LsId.setAdapter(adopter);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st=etSearch.getText().toString();
                searchAnimal(st);

            }
        });
    }

    private void searchAnimal(String st)
    {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        reference.child("MyAnimal").orderByChild("type").equalTo(st).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                adopter.clear();
                for (DataSnapshot d: dataSnapshot.getChildren())
                {
                    Animal task=d.getValue(Animal.class);
                   adopter.add(task);
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
