package com.kec.gobooks.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kec.gobooks.R;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.utils.AppLog;
import com.kec.gobooks.utils.CommunicationConstants;

public class ProfileActivity extends GoBookActivity {


    private String userProfileName;
    private String userEmailAddress;
    private String userProfilePicUrl;

    private ImageView backArrow;
    private ImageView profilePic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        getDataFromHomePage();
        initViews();
        initListener();
        setUpUserDetails();

    }

    private void getDataFromHomePage() {

        Intent intent = getIntent();
        if (intent != null){
            userProfileName = intent.getStringExtra(CommunicationConstants.USER_NAME);
            userEmailAddress = intent.getStringExtra(CommunicationConstants.USER_EMAIL);
            userProfilePicUrl = intent.getStringExtra(CommunicationConstants.USER_PROFILE_PIC);
        }


    }


    @Override
    public void initViews() {

        backArrow = findViewById(R.id.back_arrow);
        profilePic = findViewById(R.id.profile_pic);

    }

    @Override
    public void initListener() {

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProfileActivity.this.finish();

            }
        });

    }

    private void setUpUserDetails() {

        // profile

        Glide.with(this).load(userProfilePicUrl).into(profilePic);


    }
}