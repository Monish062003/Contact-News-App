package com.example.contactapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ArrAdapter extends ArrayAdapter {
    private ArrayList arrayList;
    private ListView listView1;
    private Context context,context1;

    public ArrAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> aa,ListView listView) {
        super(context, resource, aa);
        this.arrayList=aa;
        this.context=context;
        this.listView1=listView;
    }


    public ArrAdapter(@NonNull Context context1, int monish_layout,@NonNull ArrayList<String> arrayList) {
        super(context1, monish_layout, arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.monish_layout,parent,false);
        TextView t= convertView.findViewById(R.id.textView3);

        convertView.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View view) {
                                               Intent i=new Intent(context,UpdateCheck.class);
                                               SharedPreferences sharedPreferences= context.getSharedPreferences("Contacts",Context.MODE_PRIVATE);
                                               SharedPreferences.Editor ed= sharedPreferences.edit();
                                               ed.putString("pos", String.valueOf(position));
                                               ed.apply();
                                               context.startActivity(i);
                                           }
                                       });
        t.setText(getItem(position).toString());

        return convertView;
    }
}
