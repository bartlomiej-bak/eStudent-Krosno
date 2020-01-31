package com.example.estudentkrosno.ui.harmonogram;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HarmonogramViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HarmonogramViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Harmonogram zajęć");
    }

    public LiveData<String> getText() {
        return mText;
    }
}