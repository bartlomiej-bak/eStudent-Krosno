package com.example.estudentkrosno.ui.legitymacja;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LegitymacjaViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LegitymacjaViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("e-Legitymacja");
    }

    public LiveData<String> getText() {
        return mText;
    }
}