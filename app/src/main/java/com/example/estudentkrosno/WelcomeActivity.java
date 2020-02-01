package com.example.estudentkrosno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginActivityIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(loginActivityIntent);
                finish();
            }
        },1000);

    }
}
