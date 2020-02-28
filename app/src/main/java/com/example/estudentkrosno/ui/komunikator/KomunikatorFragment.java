package com.example.estudentkrosno.ui.komunikator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.estudentkrosno.R;

public class KomunikatorFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_komunikator, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        textView.setText("Komunikator");
        return root;
    }
}