package com.example.newsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    String API_KEY="95098d1d1b044f7d855e901086ddbdb0";
    private RecyclerView recyclerView;
    ArrayList<Model> models=new ArrayList<>();
    Monish_Adapter monish_adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         recyclerView=findViewById(R.id.recyclerView);

         monish_adapter=new Monish_Adapter(getApplicationContext(),models);

         recyclerView.setAdapter(monish_adapter);

         recyclerView.setLayoutManager(new LinearLayoutManager(this));

        retro.getApi().getNews("in",100,API_KEY).enqueue(new Callback<NewsImp>() {
            @Override
            public void onResponse(Call<NewsImp> call, Response<NewsImp> response) {

                    models.addAll(response.body().getArticles());
                    monish_adapter.notifyDataSetChanged();
                }

            @Override
            public void onFailure(Call<NewsImp> call, Throwable t) {

            }
        });
    }
}