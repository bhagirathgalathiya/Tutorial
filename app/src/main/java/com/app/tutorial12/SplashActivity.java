package com.app.tutorial12;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        View view=getWindow().getDecorView();
        view.setSystemUiVisibility(4);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
             startActivity(new Intent(SplashActivity.this, MainActivity.class));
             finish();
            }
        },2500);
    }
}
