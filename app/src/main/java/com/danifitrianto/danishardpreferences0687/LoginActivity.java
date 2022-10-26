package com.danifitrianto.danishardpreferences0687;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.danifitrianto.danishardpreferences0687.utils.PreferencesHelper;

public class LoginActivity extends AppCompatActivity {

    PreferencesHelper preferencesHelper;
    private Button btnLogin;
    private TextView txtSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        btnLogin = findViewById(R.id.btnLogin);
        txtSession = findViewById(R.id.txtSession);

        txtSession.setText(preferencesHelper.getLogin().toString().toUpperCase());

        btnLogin.setOnClickListener(view -> {
            Intent gotoHome = new Intent(LoginActivity.this, HomeActivity.class);

            preferencesHelper.setLogin(true);
            startActivity(preferencesHelper.getLogin() != false ? gotoHome : null);

        });

    }
}