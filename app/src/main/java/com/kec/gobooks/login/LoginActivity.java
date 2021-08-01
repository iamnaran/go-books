package com.kec.gobooks.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kec.gobooks.R;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.services.ApiClient;
import com.kec.gobooks.services.LoginApiService;

import retrofit2.Retrofit;

public class LoginActivity extends GoBookActivity implements View.OnClickListener {


    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
        initListener();

    }

    @Override
    public void initViews() {

        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.btn_login);

    }

    @Override
    public void initListener() {

        loginButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login:

                if (!emailEditText.getText().toString().isEmpty() && !passwordEditText.getText().toString().isEmpty()) {

                    // do email validation work.
                    // if  emailEditText.getText().toString()
                    // 5:28

                    doLoginWork();


                }else {

                }

                break;
        }
    }

    private void doLoginWork() {

        Toast.makeText(this, "Login Tested Called", Toast.LENGTH_SHORT).show();

    }
}