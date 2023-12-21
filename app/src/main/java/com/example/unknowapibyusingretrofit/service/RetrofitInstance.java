package com.example.unknowapibyusingretrofit.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    private  static Retrofit retrofit=null;
    private  static  String Base_URL="https://reqres.in/api/";
    public  static  GetUnknownDataService getService(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder().baseUrl(Base_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(GetUnknownDataService.class);
    }
}
