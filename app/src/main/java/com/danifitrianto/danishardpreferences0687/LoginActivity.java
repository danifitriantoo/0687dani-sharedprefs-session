package com.danifitrianto.danishardpreferences0687;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.danifitrianto.danishardpreferences0687.utils.PreferencesHelper;

public class LoginActivity extends AppCompatActivity {

    PreferencesHelper preferencesHelper;
    private Button btnLogin;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        btnLogin = findViewById(R.id.btnLogin);
        etName = findViewById(R.id.etName);

        btnLogin.setOnClickListener(view -> {
            Intent gotoHome = new Intent(LoginActivity.this, HomeActivity.class);
            if(etName.getText().toString().isEmpty()) {
                Toast.makeText(this,"Login Gagal, Nama Wajib Diisi!",Toast.LENGTH_LONG).show();
            } else {
                preferencesHelper.setLogin(etName.getText().toString());
                startActivity(preferencesHelper.getLogin().isEmpty() ? null : gotoHome);
                Toast.makeText(this,"Berhasil Login",Toast.LENGTH_LONG).show();
            }
        });

    }
}