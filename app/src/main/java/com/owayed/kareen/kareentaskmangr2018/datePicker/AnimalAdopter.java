package com.owayed.kareen.kareentaskmangr2018.datePicker;

import android.content.Context;
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
       Animal a=getItem(position);//return data object number " posotion "

        TextView etType=convertView.findViewById(R.id.etType);
        TextView etAge=convertView.findViewById(R.id.etAge);
        TextView etColor=convertView.findViewById(R.id.etColor);
        TextView etMoney=convertView.findViewById(R.id.etMoney);
        TextView etAddress=convertView.findViewById(R.id.etAddress);

        ImageButton ibPicture=convertView.findViewById(R.id.ibPicture);
        Button btnSave=convertView.findViewById(R.id.btnSave);

        // put the data of the object on the view
        etType.setText(a.getType());
        etAge.setText(a.getAge());
        etColor.setText(a.getColor());
        etMoney.setText(a.getMoney());
        etAddress.setText(a.getAddress());
        ibPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"Del",Toast.LENGTH_SHORT).show();
            }
        });




                return convertView;
    }
}
