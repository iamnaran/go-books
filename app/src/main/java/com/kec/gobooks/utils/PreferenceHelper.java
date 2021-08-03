package com.kec.gobooks.utils;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import com.google.gson.GsonBuilder;
import com.kec.gobooks.models.Login;

import static com.kec.gobooks.MyApplication.getSharedPreferences;

public class PreferenceHelper {


    public static void saveLoginResponse(Login loginResponse){
        // converted to String
        String responseOfLogin = new GsonBuilder().create().toJson(loginResponse);
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(AppConstants.LOGIN_RESPONSE,responseOfLogin);
        editor.apply();

    }



    public static Login getLoginResponse(){
        // converted to Object

        String loginResponse  = getSharedPreferences().getString(AppConstants.LOGIN_RESPONSE,null);

        Login login = new GsonBuilder().create().fromJson(loginResponse,Login.class);

        return login;

    }


    // set user status of login in shared preference


    public static void setUserLoggedIn(){
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putBoolean(AppConstants.USER_LOGGED_IN_STATUS,true);
        editor.apply();

    }



    // set user status of login in shared preference


    public static boolean isUserLoggedIn(){
        // converted to Object

        return getSharedPreferences().getBoolean(AppConstants.USER_LOGGED_IN_STATUS,false);


    }


}
