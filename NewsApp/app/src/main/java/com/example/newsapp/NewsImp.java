package com.example.newsapp;

import java.util.ArrayList;

public class NewsImp {

    private String status;
    private String totalresults;
    private ArrayList<Model> articles;

    public NewsImp(String status, String totalresults, ArrayList<Model> articles) {
        this.status = status;
        this.totalresults = totalresults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalresults(String totalresults) {
        this.totalresults = totalresults;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }


}
