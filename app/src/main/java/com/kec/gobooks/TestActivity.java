package com.kec.gobooks;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kec.gobooks.helpers.GoBookActivity;

public class TestActivity extends GoBookActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initViews();
        initListener();
    }

    @Override
    public void initViews() {

    }

    @Override
    public void initListener() {

    }
}