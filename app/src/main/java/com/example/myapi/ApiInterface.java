package com.example.myapi;

import com.example.myapi.model.Model;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {
     @POST("posts")
    public  Call<Model> setpost(@Body Model modellll);
}
