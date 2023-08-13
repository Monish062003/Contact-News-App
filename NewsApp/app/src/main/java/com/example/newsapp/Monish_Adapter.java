package com.example.newsapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Monish_Adapter extends RecyclerView.Adapter<Monish_Adapter.ViewHolder> {

    Context context;
    ArrayList<Model> models;

    public Monish_Adapter(Context context, ArrayList<Model> models) {
        this.context = context;
        this.models = models;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView headlines,mainnews,author,publishedat;
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);

            headlines = (TextView) view.findViewById(R.id.textView2);
            mainnews =view.findViewById(R.id.textView4);
            author=view.findViewById(R.id.textView5);
            publishedat=view.findViewById(R.id.textView6);
            imageView=view.findViewById(R.id.imageView);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.monish_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, @SuppressLint("RecyclerView") int position) {

       viewHolder.headlines.setText(models.get(position).getTitle());
       viewHolder.mainnews.setText(models.get(position).getDescription());
       viewHolder.author.setText(models.get(position).getAuthor());
       viewHolder.publishedat.setText(models.get(position).getPublishedAt());

        Glide.with(context).load(models.get(position).getUrlToImage()).into(viewHolder.imageView);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,Webview.class);
                i.putExtra("key",models.get(position).getUrl());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
