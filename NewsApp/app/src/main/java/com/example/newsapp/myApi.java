package com.example.newsapp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface myApi {
    String BASE_URL="https://newsapi.org/v2/";

    @GET("top-headlines")
    Call<NewsImp> getNews(
            @Query("country") String country,
            @Query("pageSize") int pagesize,
            @Query("apikey") String apikey
    );

    @GET("top_headlines")
    Call<NewsImp> getCategory(
            @Query("country") String country,
            @Query("category")String category,
            @Query("pageSize") int pagesize,
            @Query("apikey") String apikey
    );
}
