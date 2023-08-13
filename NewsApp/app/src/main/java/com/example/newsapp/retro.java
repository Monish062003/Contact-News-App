package com.example.newsapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retro {
    public  static Retrofit retrofit=null;

    public static myApi getApi() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(myApi.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return (retrofit.create(myApi.class));
    }
}
