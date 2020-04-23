package com.example.estudentkrosno;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if(android.os.Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorWelcome));
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent loginActivityIntent = new Intent(WelcomeActivity.this, LoginActivity.class);
                startActivity(loginActivityIntent);
                finish();
            }
        },2000);

    }
}
