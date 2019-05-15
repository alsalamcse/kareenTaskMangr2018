package com.owayed.kareen.kareentaskmangr2018.datePicker;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.owayed.kareen.kareentaskmangr2018.AddOfAnimal;
import com.owayed.kareen.kareentaskmangr2018.MainTapsActivity;
import com.owayed.kareen.kareentaskmangr2018.MyPage;
import com.owayed.kareen.kareentaskmangr2018.R;
import com.owayed.kareen.kareentaskmangr2018.SearchActivity;

public class AnimalAdopter extends ArrayAdapter<Animal>
{


    public AnimalAdopter(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        if(convertView==null)
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.animalitem,parent,false);
       final Animal a=getItem(position);//return data object number " posotion "

        TextView etType=convertView.findViewById(R.id.etType);
        TextView etName=convertView.findViewById(R.id.etName);
        TextView etPhoneNumber=convertView.findViewById(R.id.etPhone);
        TextView etAge=convertView.findViewById(R.id.etAge);
        TextView etColor=convertView.findViewById(R.id.etColor);
        TextView etMoney=convertView.findViewById(R.id.etMoney);
        TextView etAddress=convertView.findViewById(R.id.etAddress);

        ImageButton ibPicture=convertView.findViewById(R.id.ibPicture);
        Button btnIWant=convertView.findViewById(R.id.btnSave);

        // put the data of the object on the view
        etPhoneNumber.setText(a.getPhoneNumber());
        etName.setText(a.getName());
        etType.setText(a.getType());
        etAge.setText(a.getAge());
        etColor.setText(a.getColor());
        etMoney.setText(a.getMoney());
        etAddress.setText(a.getAddress());

        btnIWant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Del",Toast.LENGTH_SHORT).show();

                FirebaseAuth auth=FirebaseAuth.getInstance();
                DatabaseReference reference= FirebaseDatabase.getInstance().getReference();

                reference.child(auth.getUid()).child("MyAnimal").child(a.getKey()).setValue(a).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task)
                    {
                        if (task.isSuccessful())
                        {
                            Toast.makeText(getContext(),"add Successful",Toast.LENGTH_LONG).show();
                            Intent i=new Intent(getContext(),MainTapsActivity.class);
                            ((SearchActivity)getContext()).finish();
                        }
                        else
                        {

                        }
                    }
                });
                sendSMSMessage(a.getPhoneNumber(),"i want to adoupt your animal");

//                SmsManager smsManager = SmsManager.getDefault();
//                smsManager.sendTextMessage(a.getEmail(), null, "i want to adoupt your animal", null, null);
            }
        });

                return convertView;
    }



    protected void sendSMSMessage(String phoneNumber, String s) {


        if (ContextCompat.checkSelfPermission(getContext(),
                Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) getContext(),
                    Manifest.permission.SEND_SMS)) {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(phoneNumber, null, s, null, null);
            } else {
                ActivityCompat.requestPermissions((Activity) getContext(),
                        new String[]{Manifest.permission.SEND_SMS},
                        100);
            }
        }
    }

//    @Override
//    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
//        switch (requestCode) {
//            case 100: {
//                if (grantResults.length > 0
//                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                    SmsManager smsManager = SmsManager.getDefault();
//                    smsManager.sendTextMessage(phoneNo, null, message, null, null);
//                    Toast.makeText(getApplicationContext(), "SMS sent.",
//                            Toast.LENGTH_LONG).show();
//                } else {
//                    Toast.makeText(getApplicationContext(),
//                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
//                    return;
//                }
//            }
//        }
//
//    }



}
