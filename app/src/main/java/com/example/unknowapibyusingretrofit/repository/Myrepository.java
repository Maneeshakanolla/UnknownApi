package com.example.unknowapibyusingretrofit.repository;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.unknowapibyusingretrofit.model.Unknown;
import com.example.unknowapibyusingretrofit.service.GetUnknownDataService;
import com.example.unknowapibyusingretrofit.service.RetrofitInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Myrepository {
    GetUnknownDataService getUnknownDataService;

    public Myrepository() {
        this.getUnknownDataService =new RetrofitInstance().getService();

    }

    public LiveData<Unknown> questionFromApi(){
        MutableLiveData<Unknown> data=new MutableLiveData<>();

        Call<Unknown> response = getUnknownDataService.getUnknown();
        response.enqueue(new Callback<Unknown>() {
            @Override
            public void onResponse(Call<Unknown> call, Response<Unknown> response) {
                Unknown unknown =response.body();
                data.setValue(unknown);

            }

            @Override
            public void onFailure(Call<Unknown> call, Throwable t) {

            }
        });
        return  data;
    }
}
