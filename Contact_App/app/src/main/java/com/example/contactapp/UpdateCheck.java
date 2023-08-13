package com.example.contactapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpdateCheck extends AppCompatActivity {

    private TextView textView;
    private EditText editText1,editText2,editText3,editText4,editText5,editText6;
    private Button savechanges,delete;
    private ImageButton imageButton;
    private int position,posi,a=0;
    private ArrayAdapter arrayAdapter;
    private ArrayList<String> arrayList=new ArrayList<String>();
    private ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_check);

        textView=findViewById(R.id.textView10);

        editText1=findViewById(R.id.editTextTextPersonName);
        editText2=findViewById(R.id.editTextTextPersonName2);
        editText3=findViewById(R.id.editTextTextPersonName3);
        editText4=findViewById(R.id.editTextTextPersonName4);
        editText5=findViewById(R.id.editTextTextPersonName5);
        editText6=findViewById(R.id.editTextTextPersonName6);

        savechanges=findViewById(R.id.button);
        delete=findViewById(R.id.button2);

        imageButton=findViewById(R.id.imageButton2);

        SharedPreferences sharedPreferences=getSharedPreferences("Contacts",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        position= Integer.parseInt(sharedPreferences.getString("pos",null));

        String fname= sharedPreferences.getString("storage",null);
        String[] fnames = fname.split(",");

        String pho= sharedPreferences.getString("phone",null);
        String[] phoneno = pho.split(",");

        posi= Integer.parseInt(sharedPreferences.getString("posi",null));


        textView.setText(fnames[position]);
        editText1.setText(fnames[position]);
        editText2.setText(phoneno[position]);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(UpdateCheck.this,MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        savechanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] fnames = fname.split(",");

                fnames[position]=editText1.getText().toString();
                phoneno[position]=editText2.getText().toString();

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < posi+1; i++) {
                    sb.append(fnames[i]).append(",");
                }

                StringBuilder sbi = new StringBuilder();
                for (int i = 0; i < posi+1; i++) {
                    sbi.append(phoneno[i]).append(",");
                }


                SharedPreferences sharedPreferences=getSharedPreferences("Contacts",MODE_PRIVATE);
                SharedPreferences.Editor editor1=sharedPreferences.edit();
                editor1.putString("storage", sb.toString());
                editor1.putString("phone", sbi.toString());

                editor1.apply();

                Intent intent=new Intent(UpdateCheck.this,MainActivity.class);
                startActivity(intent);
                finish();

                Toast.makeText(UpdateCheck.this, "Changes Saved", Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a=1;

                Intent intent=new Intent(UpdateCheck.this,MainActivity.class);
                intent.putExtra("condition",a);
                startActivity(intent);
                finish();

                Toast.makeText(UpdateCheck.this, "Deleted", Toast.LENGTH_SHORT).show();
            }
        });

    }
}