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
    private TextView txtSession;
    private EditText etName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        btnLogin = findViewById(R.id.btnLogin);
        etName = findViewById(R.id.etName);
        txtSession = findViewById(R.id.txtSession);

        txtSession.setText(preferencesHelper.getLogin().toString().toUpperCase());

        btnLogin.setOnClickListener(view -> {
            Intent gotoHome = new Intent(LoginActivity.this, HomeActivity.class);
            if(etName.getText().toString().isEmpty()) {
                Toast.makeText(this,"Login Gagal, Nama Wajib Diisi!",Toast.LENGTH_LONG).show();
            } else {
                preferencesHelper.setLogin(true,etName.getText().toString());
                startActivity(preferencesHelper.getLogin() != false ? gotoHome : null);
                Toast.makeText(this,"Berhasil Login",Toast.LENGTH_LONG).show();
            }

        });

    }
}