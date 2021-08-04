package com.kec.gobooks.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.kec.gobooks.ui.home.HomeActivity;
import com.kec.gobooks.ui.login.LoginActivity;
import com.kec.gobooks.R;
import com.kec.gobooks.utils.PreferenceHelper;

public class SplashActivity extends AppCompatActivity {


    private final String TAG = SplashActivity.this.getClass().getSimpleName();

    private ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Log.e(TAG,"called Before ");

        initView();
        initListeners();



        doSplashLoadingWork();


    }

    // do initialise work
    private void initView() {
        imageView = findViewById(R.id.logo_image);
        Glide.with(SplashActivity.this).load(R.drawable.ic_logo).into(imageView);

    }


    // do initialise listener work
    private void initListeners() {

    }


    // do timer/handler running work for 5 sec then dismiss
    private void doSplashLoadingWork() {

        // this handler
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                openMainActivity();


            }
        },2000);



    }

    private void openMainActivity() {

        if (PreferenceHelper.isUserLoggedIn()){

            // do user already logged in work
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
            finish();

        }else {
            // user not logged in
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();


        }


    }





}