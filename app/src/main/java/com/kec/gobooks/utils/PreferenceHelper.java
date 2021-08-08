package com.kec.gobooks.utils;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kec.gobooks.models.Category;
import com.kec.gobooks.models.Login;

import static com.kec.gobooks.MyApplication.getSharedPreferences;

public class PreferenceHelper {

    // converted to String before saving
    public static void saveLoginResponse(Login loginResponse){
        String responseOfLogin = new GsonBuilder().create().toJson(loginResponse);
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(AppConstants.LOGIN_RESPONSE,responseOfLogin);
        editor.apply();
    }


    // return login converted to Object from string value saved in shared preference
    public static Login getLoginResponse(){
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


    // return is user logged in value
    public static boolean isUserLoggedIn(){
        return getSharedPreferences().getBoolean(AppConstants.USER_LOGGED_IN_STATUS,false);
    }


    public static void saveCategoryResponse(Category category){
        String categoryResponse = new GsonBuilder().create().toJson(category);
        SharedPreferences.Editor editor = getSharedPreferences().edit();
        editor.putString(AppConstants.BOOKS_CATEGORY, categoryResponse);
        editor.apply();

    }

    public Category getCategoryResponse(){

        String categoryLocalStorageData = getSharedPreferences().getString(AppConstants.BOOKS_CATEGORY,null);
        return new GsonBuilder().create().fromJson(categoryLocalStorageData,Category.class);

    }



}
