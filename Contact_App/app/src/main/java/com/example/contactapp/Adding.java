package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Adding extends AppCompatActivity {

private EditText Fname,Lname,Email,Address,Phoneno,Telephone;
private Button save,cancel;
private String [] fnames=new String[100];
private String [] phones=new String[100];
//private String [] lnames=new String[100];
private int position;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        save=findViewById(R.id.save);
        cancel=findViewById(R.id.cancel);

        Fname=findViewById(R.id.fname);
//        Lname=findViewById(R.id.lname);
        Email=findViewById(R.id.email);
        Address=findViewById(R.id.address);
        Phoneno=findViewById(R.id.pnumber);
        Telephone=findViewById(R.id.tphone);

        SharedPreferences sharedPreferences=getSharedPreferences("Contacts",MODE_PRIVATE);
        String storednewname=sharedPreferences.getString("storage","");
        String[] nameo = storednewname.split(",");

        String storedphone=sharedPreferences.getString("phone","");
        String[] phone = storedphone.split(",");

        String storedlname=sharedPreferences.getString("phone","");
        String[] adios = storedlname.split(",");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String fname= Fname.getText().toString();
//                String lname= Lname.getText().toString();
                String phoneno= Phoneno.getText().toString();
                String telephone= Telephone.getText().toString();
                String address= Address.getText().toString();
                String email= Email.getText().toString();


                if(fname.equals(""))
                {
                    Toast.makeText(Adding.this, "Name is Required", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    if(phoneno.equals(""))
                    {
                        Toast.makeText(Adding.this, phoneno+"Phone Number is Required", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(phoneno.length()==10)
                        {
                            firstnames(fname,nameo);
                            phones(phoneno,phone);

                            Intent save=new Intent(Adding.this,MainActivity.class);
//                            if(!lname.equals(""))
//                            {
//                                lastnames(lname,adios);
//                            }
//                            else
//                            {
//                                lname=" ";
//                                lastnames(lname,adios);
//                            }
                            startActivity(save);
                            finish();
                        }
                        else
                        {
                            Toast.makeText(Adding.this, "The number limit should be 10", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cancel=new Intent(Adding.this,MainActivity.class);
                startActivity(cancel);
                finish();
            }
        });
    }
    public void firstnames(String fname,String [] nameo)
    {
        for (int i = 0; i < nameo.length; i++) {
            fnames[i]=nameo[i];
        }
        for (int i = 0; i < fnames.length+1; i++) {
            if(fnames[i]==null)
            {
                fnames[i]=fname;
                position=i;
                break;
            }
        }
        SharedPreferences sp=getSharedPreferences("Contacts",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position+1; i++) {
            sb.append(fnames[i]).append(",");
        }
        ed.putString("storage", sb.toString());

        ed.apply();
    }

    public void phones(String phoneno,String [] phone)
    {
        for (int i = 0; i < phone.length; i++) {
            phones[i]=phone[i];
        }
        for (int i = 0; i < phones.length+1; i++) {
            if(phones[i]==null)
            {
                phones[i]=phoneno;
                position=i;
                break;
            }
        }
        SharedPreferences sp=getSharedPreferences("Contacts",MODE_PRIVATE);
        SharedPreferences.Editor ed=sp.edit();
        ed.putString("posi", String.valueOf(position));
        ed.apply();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position+1; i++) {
            sb.append(phones[i]).append(",");
        }
        ed.putString("phone", sb.toString());

        ed.apply();
    }

}