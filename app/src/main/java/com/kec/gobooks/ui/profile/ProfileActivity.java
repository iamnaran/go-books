package com.kec.gobooks.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.kec.gobooks.R;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.utils.AppLog;
import com.kec.gobooks.utils.CommunicationConstants;

public class ProfileActivity extends GoBookActivity {


    private String fullName;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getDataFromHomePage();
        initViews();
        initListener();

    }

    private void getDataFromHomePage() {

        Intent intent = getIntent();
        fullName = intent.getStringExtra(CommunicationConstants.PROFILE_DATA);
        AppLog.showLog("CALLED", fullName);

    }

    @Override
    public void initViews() {

        textView1 = findViewById(R.id.text_view_1);
        textView1.setText("This is work"+ fullName);

    }

    @Override
    public void initListener() {

    }
}