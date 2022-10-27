package com.danifitrianto.danishardpreferences0687.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferencesHelper {
    private static PreferencesHelper INSTANCE;
    private SharedPreferences sharedPreferences;
    private final String root = "com.danifitrianto.danishardpreferences0687";

    public PreferencesHelper(Context context) {
        sharedPreferences = context.getApplicationContext()
                .getSharedPreferences(root,0);
    }

    public static PreferencesHelper getInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = new PreferencesHelper(context);
        }
        return INSTANCE;
    }

    public SharedPreferences PreferencesHelper() {
        return sharedPreferences;
    };

    public void setLogin(String name) {
        sharedPreferences.edit().putString("loginName",name).apply();
    }

    public String getLogin() {
        return sharedPreferences.getString("loginName","");
    }
}
