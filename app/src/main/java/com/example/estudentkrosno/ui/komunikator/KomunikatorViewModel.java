package com.example.estudentkrosno.ui.komunikator;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KomunikatorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KomunikatorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Komunikator");
    }

    public LiveData<String> getText() {
        return mText;
    }
}