package com.example.estudentkrosno.ui.harmonogram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.estudentkrosno.R;

public class HarmonogramFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_harmonogram, container, false);
        //final TextView textView = root.findViewById(R.id.text_slideshow);
        //textView.setText("Harmonogram zajęć");
        return root;
    }
}