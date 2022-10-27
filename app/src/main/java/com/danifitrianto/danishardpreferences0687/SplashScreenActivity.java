package com.danifitrianto.danishardpreferences0687;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.danifitrianto.danishardpreferences0687.utils.PreferencesHelper;

public class SplashScreenActivity extends AppCompatActivity {

    PreferencesHelper preferencesHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        int splashIntv = 3000;

        new Handler().postDelayed(() -> {
            Intent gotoLogin = new Intent(
                    SplashScreenActivity.this,LoginActivity.class);
            Intent gotoHome = new Intent(
                    SplashScreenActivity.this,HomeActivity.class);

            startActivity(preferencesHelper.getLogin().isEmpty() ? gotoLogin : gotoHome);
        },splashIntv);
    }
}