package com.example.estudentkrosno.ui.aktulanosci;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AktualnosciViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public AktualnosciViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Aktualności");
    }

    public LiveData<String> getText() {
        return mText;
    }
}