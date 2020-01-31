package com.example.estudentkrosno.ui.oceny;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OcenyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public OcenyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Moje oceny");
    }

    public LiveData<String> getText() {
        return mText;
    }
}