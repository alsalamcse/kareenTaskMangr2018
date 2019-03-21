package com.owayed.kareen.kareentaskmangr2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private Button btnSearch;
    private EditText etSearch;
    private ListView LsId;
    private ArrayAdapter arrayAdapter;
    private ArrayList arrayList;
 AnimalAdopter adopter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        btnSearch=findViewById(R.id.btnSearch);
        etSearch=findViewById(R.id.etSearch);
        LsId=(ListView)findViewById(R.id.LsId);

        adopter=new AnimalAdopter(getBaseContext(),R.layout.animalitem);
        LsId.setAdapter(adopter);
        getAll();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st=etSearch.getText().toString();
                if(st!=null && st.length()>0)
                searchAnimal(st);
                else
                    getAll();
            }
        });

    }

    private void searchAnimal(final String st)
    {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
       // reference.child("MyAnimal").orderByChild("type").equalTo(st).addValueEventListener(new ValueEventListener() {
        reference.child("MyAnimal").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                adopter.clear();
                for (DataSnapshot d: dataSnapshot.getChildren())
                {

                    Animal task=d.getValue(Animal.class);
                    if(task.getType().equals(st))
                   adopter.add(task);
                }
                adopter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void getAll()
    {
        DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
        reference.child("MyAnimal").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                adopter.clear();
                for (DataSnapshot d: dataSnapshot.getChildren())
                {

                    Animal task=d.getValue(Animal.class);

                        adopter.add(task);
                }
                adopter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
