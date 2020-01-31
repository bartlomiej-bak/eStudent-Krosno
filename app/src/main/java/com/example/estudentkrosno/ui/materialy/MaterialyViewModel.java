package com.example.estudentkrosno.ui.materialy;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MaterialyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public MaterialyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Materiały do zajęć");
    }

    public LiveData<String> getText() {
        return mText;
    }
}