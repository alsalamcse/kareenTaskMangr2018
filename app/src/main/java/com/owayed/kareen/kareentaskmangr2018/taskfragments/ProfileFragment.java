package com.owayed.kareen.kareentaskmangr2018.taskfragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.owayed.kareen.kareentaskmangr2018.R;
import com.owayed.kareen.kareentaskmangr2018.WhoAskActivity;
import com.owayed.kareen.kareentaskmangr2018.datePicker.MyProfile;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
private EditText etName,etPhone,etAge,etEmail;
private Button btnSave;
private FirebaseAuth auth;



    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile,container,false);
        etName=view.findViewById(R.id.etName);
        etPhone=view.findViewById(R.id.etPhone);
        etAge=view.findViewById(R.id.etAge);
        etEmail=view.findViewById(R.id.etEmail);
        btnSave=view.findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),WhoAskActivity.class);
            }
        });
        getProfile();

        return view;


    }

    private void getProfile() {
        DatabaseReference reference=FirebaseDatabase.getInstance().getReference();
        String email=FirebaseAuth.getInstance().getCurrentUser().getEmail();
        reference.child("MyProfile").child(email.replace('.','*')).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                DataSnapshot d=dataSnapshot.getChildren().iterator().next();
                MyProfile p=d.getValue(MyProfile.class);
                etName.setText(p.getName());
                etAge.setText(p.getAge());
                etEmail.setText(p.getEmail());
                etPhone.setText(p.getPhoneNumber());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getContext(),"onCancelled",Toast.LENGTH_SHORT).show();

            }
        })

    }

}
