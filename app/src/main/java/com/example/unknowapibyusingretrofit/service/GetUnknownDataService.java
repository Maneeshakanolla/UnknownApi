package com.example.unknowapibyusingretrofit.service;

import com.example.unknowapibyusingretrofit.model.Unknown;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetUnknownDataService {
    @GET("unknown")
    Call<Unknown> getUnknown();
}
