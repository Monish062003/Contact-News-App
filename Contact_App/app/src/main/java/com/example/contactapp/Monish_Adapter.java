package com.example.contactapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Monish_Adapter extends ArrayAdapter<String> {

    private String [] fnames;

    public Monish_Adapter(@NonNull Context context, int resource, @NonNull String[] fnames) {
        super(context, resource, fnames);
        this.fnames=fnames;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.monish_layout,parent,false);
        TextView t=convertView.findViewById(R.id.textView3);
        t.setText(getItem(position));
        return convertView;
    }
}
