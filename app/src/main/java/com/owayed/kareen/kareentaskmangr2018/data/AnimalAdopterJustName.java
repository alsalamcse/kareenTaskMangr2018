package com.owayed.kareen.kareentaskmangr2018.data;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.owayed.kareen.kareentaskmangr2018.ActivityDetails;
import com.owayed.kareen.kareentaskmangr2018.R;

public class AnimalAdopterJustName extends ArrayAdapter<Animal>
{


    public AnimalAdopterJustName(Context context, int resource) {
        super(context, resource);
    }


    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {

        if(convertView==null)
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.animalitemname,parent,false);
       final Animal a=getItem(position);//return data object number " posotion "


        TextView etName=convertView.findViewById(R.id.etName);

        Button btnMoreDetails=convertView.findViewById(R.id.btnMoreDetails);

        // put the data of the object on the view

        etName.setText(a.getName());


//        if (a.getWhoWant()!=null && a.getWhoWant().length()>0)
//            btnMoreDetails.setEnabled(false);
//        else
        btnMoreDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getContext(),ActivityDetails.class);
                i.putExtra("animal",a);
                getContext().startActivity(i);

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
