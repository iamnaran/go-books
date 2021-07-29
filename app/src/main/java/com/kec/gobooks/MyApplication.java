package com.kec.gobooks;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyApplication extends Application{

    private static MyApplication myApplication;

    private static SharedPreferences sharedPreferences;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

    }

    public static Context getAppContext(){

        return myApplication.getApplicationContext();
    }


    public static SharedPreferences getSharedPreferences(){

        return sharedPreferences;
    }


}
