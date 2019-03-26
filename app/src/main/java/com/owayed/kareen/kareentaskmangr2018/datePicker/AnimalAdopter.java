package com.owayed.kareen.kareentaskmangr2018.datePicker;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
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

import com.owayed.kareen.kareentaskmangr2018.R;

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
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(a.getEmail(), null, "i want to adoupt your animal", null, null);
            }
        });

                return convertView;
    }





}
