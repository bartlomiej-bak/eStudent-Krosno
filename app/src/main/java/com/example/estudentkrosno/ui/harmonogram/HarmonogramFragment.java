package com.example.estudentkrosno.ui.harmonogram;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.estudentkrosno.R;

public class HarmonogramFragment extends Fragment {

    private WebView harmWebView;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_harmonogram, container, false);
        harmWebView = root.findViewById(R.id.harmonogramWebView);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadUrl();
    }

    private void loadUrl(){
        harmWebView.getSettings().setJavaScriptEnabled(true);
        harmWebView.loadUrl("https://drive.google.com/file/d/1qixwY_PA_70HodLkuSjkLi5NcCAtsv_g/view?usp=sharing");
    }
}