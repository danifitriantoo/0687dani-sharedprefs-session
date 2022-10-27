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

    public void setLogin(Boolean session,String name) {
        sharedPreferences.edit().putBoolean("isLogin",session).apply();
        sharedPreferences.edit().putString("loginName",name).apply();
    }

    public Boolean getLogin() {
        return sharedPreferences.getBoolean("isLogin",false);
    }

    public String getName() {
        return sharedPreferences.getString("loginName","");
    }
}
