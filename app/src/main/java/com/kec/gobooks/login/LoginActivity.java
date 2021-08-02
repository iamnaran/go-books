package com.kec.gobooks.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kec.gobooks.R;
import com.kec.gobooks.controller.LoginController;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.services.ApiClient;
import com.kec.gobooks.services.LoginApiService;
import com.kec.gobooks.utils.AppToast;

import retrofit2.Retrofit;

public class LoginActivity extends GoBookActivity implements View.OnClickListener , LoginController.LoginContract {


    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private LoginController loginController;


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

        loginController =

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_login:

                String editTextEmailValue = emailEditText.getText().toString();
                String editTextPasswordValue = passwordEditText.getText().toString();

                if (editTextEmailValue.isEmpty() || editTextPasswordValue.isEmpty()) {
                    AppToast.showToast("Called");
                    emailEditText.setError("Email fields is mandatory");
                    passwordEditText.setError("Password fields is mandatory");
                    return;
                }
                if (Patterns.EMAIL_ADDRESS.matcher(editTextEmailValue).matches()) {

                    doLoginApiRequestWork();


                } else {
                    AppToast.showToast("Valid Email Address required");
                    emailEditText.setError("Valid Email is Required");

                }


                break;
        }
    }

    private void doLoginApiRequestWork() {




    }


    @Override
    public void onLoginResponseSuccess(String message) {

        AppToast.showToast(message);

    }

    @Override
    public void onLoginFailed() {

    }
}