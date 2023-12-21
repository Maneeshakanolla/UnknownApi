package com.example.unknowapibyusingretrofit.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.unknowapibyusingretrofit.model.Unknown;
import com.example.unknowapibyusingretrofit.repository.Myrepository;

public class UnknownViewModel extends ViewModel {
    Myrepository repository= new Myrepository();
    LiveData<Unknown> questionListLiveData;
}
