package com.kec.gobooks.utils;

import android.content.Context;
import android.widget.Toast;

import com.kec.gobooks.MyApplication;

public class AppToast {

    public static void showToast( String message) {
        Toast.makeText(MyApplication.getAppContext(), message, Toast.LENGTH_SHORT).show();
    }
}
