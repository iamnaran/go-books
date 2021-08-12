package com.kec.gobooks.ui.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kec.gobooks.R;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.ui.login.LoginActivity;
import com.kec.gobooks.utils.AppLog;
import com.kec.gobooks.utils.CommunicationConstants;
import com.kec.gobooks.utils.PreferenceHelper;

import static com.kec.gobooks.utils.PreferenceHelper.doLogoutWork;

public class ProfileActivity extends GoBookActivity {


    private String userProfileName;
    private String userEmailAddress;
    private String userProfilePicUrl;

    private ImageView backArrow;
    private ImageView profilePic;
    private Button logoutBtn;


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
        if (intent != null) {
            userProfileName = intent.getStringExtra(CommunicationConstants.USER_NAME);
            userEmailAddress = intent.getStringExtra(CommunicationConstants.USER_EMAIL);
            userProfilePicUrl = intent.getStringExtra(CommunicationConstants.USER_PROFILE_PIC);
        }


    }


    @Override
    public void initViews() {

        backArrow = findViewById(R.id.back_arrow);
        profilePic = findViewById(R.id.profile_pic);
        logoutBtn = findViewById(R.id.logoutBtn);

    }

    @Override
    public void initListener() {

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProfileActivity.this.finish();

            }
        });


        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showLogoutDialog();
            }
        });

    }


    private void setUpUserDetails() {

        // profile
        Glide.with(this).load(userProfilePicUrl).into(profilePic);


    }


    private void showLogoutDialog() {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
        builder1.setMessage("Are you sure, you want to logout? Some cached data will be erased");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Sure!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        PreferenceHelper.doLogoutWork();
                        doStartLoginActivityWork();
                        dialog.dismiss();


                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }

    private void doStartLoginActivityWork() {

        Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}