package com.example.unknowapibyusingretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.unknowapibyusingretrofit.adapter.UnknownAdapter;
import com.example.unknowapibyusingretrofit.model.Datum;
import com.example.unknowapibyusingretrofit.model.Support;
import com.example.unknowapibyusingretrofit.model.Unknown;
import com.example.unknowapibyusingretrofit.service.GetUnknownDataService;
import com.example.unknowapibyusingretrofit.service.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UnknownAdapter unknownAdapter;
    ArrayList<Datum> datumList;

    ArrayList<Support> support;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getDatum();
        //getSupport();
    }
    public Object getDatum(){
        GetUnknownDataService getUnknownDataService= RetrofitInstance.getService();

        Call<Unknown> call=getUnknownDataService.getUnknown();

        call.enqueue(new Callback<Unknown>() {
            @Override
            public void onResponse(Call<Unknown> call, Response<Unknown> response) {
                Unknown result = response.body();

                if(result!= null && result.getData() !=null){
                    datumList = (ArrayList<Datum>) result.getData();

                    for(Datum c: datumList){
                        Log.d("TAG", c.getName());


                    }

                    ViewData();
                }
            }


            @Override
            public void onFailure(Call<Unknown> call, Throwable t) {

            }
        });

        return datumList;
    }


    private void ViewData() {

        recyclerView = findViewById(R.id.recyclerView);
        unknownAdapter = new UnknownAdapter(datumList,this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(unknownAdapter);
    }
}