package com.danifitrianto.danishardpreferences0687;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.danifitrianto.danishardpreferences0687.utils.PreferencesHelper;

public class HomeActivity extends AppCompatActivity {

    PreferencesHelper preferencesHelper;
    private Button btnLogout;
    private TextView txtSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        preferencesHelper = PreferencesHelper.getInstance(getApplicationContext());

        txtSession = findViewById(R.id.txtSession);
        txtSession.setText(preferencesHelper.getLogin().toString().toUpperCase());

        btnLogout = findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view -> {
            AlertDialog.Builder logoutConfirmation = new AlertDialog.Builder(this)
                   .setTitle("Keluar")
                   .setMessage("Anda yakin ingin keluar?");

            logoutConfirmation.setPositiveButton("YA", (dialogInterface, i) -> {
                try {
                   preferencesHelper.setLogin(false);
                } finally {
                   if(preferencesHelper.getLogin() != true) {
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