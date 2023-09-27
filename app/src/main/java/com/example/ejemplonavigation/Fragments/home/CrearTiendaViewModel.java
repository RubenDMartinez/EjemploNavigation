package com.example.ejemplonavigation.Fragments.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CrearTiendaViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CrearTiendaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}