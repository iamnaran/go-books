package com.kec.gobooks.utils;

import android.util.Log;
import android.widget.Toast;

import com.kec.gobooks.MyApplication;

public class AppLog {

    public static void showLog(String TAG, String message) {

        Log.e(TAG +"ANDROID DEBUGGING --> ",message);

    }
}
