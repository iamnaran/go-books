package com.kec.gobooks.ui.main.login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kec.gobooks.R;
import com.kec.gobooks.models.Login;
import com.kec.gobooks.ui.main.MainActivity;
import com.kec.gobooks.ui.main.login.controller.LoginContract;
import com.kec.gobooks.ui.main.login.controller.LoginController;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.ui.main.splash.SplashActivity;
import com.kec.gobooks.utils.AppToast;
import com.kec.gobooks.utils.PreferenceHelper;

public class LoginActivity extends GoBookActivity implements View.OnClickListener, LoginContract {


    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView createAccountBtn;

    private ProgressBar progressBar;

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
        progressBar = findViewById(R.id.progress_bar);
        createAccountBtn = findViewById(R.id.tv_create_new_account);

    }

    @Override
    public void initListener() {

        loginButton.setOnClickListener(this);
        createAccountBtn.setOnClickListener(this);


        loginController = new LoginController(this);

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

                    showProgressBar();
                    loginController.doLoginWork(editTextEmailValue, editTextPasswordValue);

                } else {

                    AppToast.showToast("Valid Email Address required");
                    emailEditText.setError("Valid Email is Required");

                }


                break;


            case R.id.tv_create_new_account:

                // tv sign up called


                break;
        }
    }


    @Override
    public void onLoginResponseSuccess(Login login) {

        PreferenceHelper.saveLoginResponse(login);
        PreferenceHelper.setUserLoggedIn();
        hideProgressBar();
        doAfterLoginSuccessWork();


    }

    private void doAfterLoginSuccessWork() {

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailed() {

        hideProgressBar();


    }

    private void showProgressBar() {

        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }


    private void hideProgressBar() {

        if (progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }


}