package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageButton imageButton;
    private TextView textView,textView1,textView2;
    private String phoneno="0";
    private ListView listView;
    private ArrayAdapter arrayAdapter;
    private List arr=new ArrayList();
    private List arr1=new ArrayList();
    private List arr3=new ArrayList();
    private String [] name=new String[10];
    private ArrayList arrayList,arrayList1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageButton=findViewById(R.id.imageButton1);
        textView=findViewById(R.id.textView);
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        listView=findViewById(R.id.lista);

        try {
            SharedPreferences sharedPreferences=getSharedPreferences("Contacts",MODE_PRIVATE);
            String phoneno= sharedPreferences.getString("phone","0");
            String fname= sharedPreferences.getString("storage",null);
            String lname= sharedPreferences.getString("lnames",null);

            String[] fnames = fname.split(",");
            String[] phones = phoneno.split(",");

            int condition=getIntent().getIntExtra("condition",0);

            if (condition==1)
            {
                int finalposition=Integer.parseInt(sharedPreferences.getString("posi",null));
                int position=Integer.parseInt(sharedPreferences.getString("pos",null));

                finalposition--;

                fnames[0]="All Contacts";
                Collections.addAll(arr,fnames);
                ArrayList arrayList=new ArrayList(arr);
                arrayList.remove(position);

                Collections.addAll(arr1,phones);
                ArrayList arrayList1=new ArrayList(arr1);
                arrayList1.remove(position);

                ArrAdapter arrAdapter=new ArrAdapter(this,R.layout.monish_layout,arrayList);
                listView.setAdapter(arrAdapter);

                fname = String.join(",", arrayList);
                phoneno = String.join(",", arrayList1);

                fnames = fname.split(",");
                phones = phoneno.split(",");

//                int a=0;
                condition=0;

                SharedPreferences.Editor editor= sharedPreferences.edit();
                editor.putString("storage",fname);
                editor.putString("phone",phoneno);
                editor.putString("condition", String.valueOf(condition));
                editor.putString("posi", String.valueOf(finalposition));
                editor.putString("pos", String.valueOf(position));
                editor.apply();
            }

            if (!phoneno.equals("0"))
            {
                textView.setText("");
                textView1.setText("");
                textView2.setText("");
            }
            if (condition!=1)
            {
                fnames[0]="All Contacts";
                Collections.addAll(arr3,fnames);

                ArrayList aa=new ArrayList(arr3);

                ArrAdapter arrAdapter=new ArrAdapter(this,R.layout.monish_layout,aa,listView);
                listView.setAdapter(arrAdapter);

            }
        }
        catch (Exception e)
        {

        }



        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add=new Intent(MainActivity.this,Adding.class);
                startActivity(add);
                finish();
            }
        });
    }
}