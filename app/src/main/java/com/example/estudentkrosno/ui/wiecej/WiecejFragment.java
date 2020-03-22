package com.example.estudentkrosno.ui.wiecej;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.estudentkrosno.R;

public class WiecejFragment extends Fragment {

    private Button buttonWyjscie;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_wiecej, container, false);
    }


}