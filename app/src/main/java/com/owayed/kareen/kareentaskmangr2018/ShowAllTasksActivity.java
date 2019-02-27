package com.owayed.kareen.kareentaskmangr2018;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.owayed.kareen.kareentaskmangr2018.datePicker.Animal;
import com.owayed.kareen.kareentaskmangr2018.datePicker.TaskAdopter;

public class ShowAllTasksActivity extends AppCompatActivity {
    private ListView IvAnimal;
    private TaskAdopter animalAdopter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_all_tasks);
        IvAnimal=findViewById(R.id.ListAnimal);
        animalAdopter=new TaskAdopter(getBaseContext(),R.layout.taskitim);
        IvAnimal.setAdapter(animalAdopter);



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
}
