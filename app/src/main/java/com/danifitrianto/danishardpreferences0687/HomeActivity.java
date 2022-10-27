package com.danifitrianto.danishardpreferences0687;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.*;

import com.danifitrianto.danishardpreferences0687.utils.PreferencesHelper;

public class HomeActivity extends AppCompatActivity {

    PreferencesHelper preferencesHelper;
    private Button btnLogout;
    private TextView tvName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        tvName = findViewById(R.id.tvName);
        tvName.setText(preferencesHelper.getLogin());

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view -> {
            AlertDialog.Builder logoutConfirmation = new AlertDialog.Builder(this)
                   .setTitle("Keluar")
                   .setMessage("Anda yakin ingin keluar?");

            logoutConfirmation.setPositiveButton("YA", (dialogInterface, i) -> {
                try {
                   preferencesHelper.setLogin("");
                } finally {
                   if(preferencesHelper.getLogin().isEmpty()) {
                       try {
                           Toast.makeText(this,"Berhasil Logout", Toast.LENGTH_LONG).show();
                       } finally {
                           Intent gotoLogin = new Intent(
                                   HomeActivity.this,LoginActivity.class);
                           startActivity(gotoLogin);
                       }
                   }
                }
            });

            logoutConfirmation.setNegativeButton("TIDAK", (dialogInterface, i) -> {
                dialogInterface.cancel();
            });

            logoutConfirmation.create().show();
        });
    }
}