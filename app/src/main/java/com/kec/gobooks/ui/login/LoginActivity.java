package com.kec.gobooks.ui.login;

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
import com.kec.gobooks.ui.login.controller.LoginContract;
import com.kec.gobooks.ui.login.controller.LoginController;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.utils.AppToast;
import com.kec.gobooks.utils.PreferenceHelper;

public class LoginActivity extends GoBookActivity implements View.OnClickListener, LoginContract {


    // view classes

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView createAccountBtn;
    private ProgressBar progressBar;

    // A controller class to handle logical operation
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

        // view initialisation / finding

        emailEditText = findViewById(R.id.et_email);
        passwordEditText = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.btn_login);
        progressBar = findViewById(R.id.progress_bar);
        createAccountBtn = findViewById(R.id.tv_create_new_account);

    }

    @Override
    public void initListener() {

        // view listeners events

        loginButton.setOnClickListener(this);
        createAccountBtn.setOnClickListener(this);
        loginController = new LoginController(this);

    }

    @Override
    public void onClick(View v) {


        // all  clicked event will be here.


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

        // this function is called after controller give response to success

        PreferenceHelper.saveLoginResponse(login);
        PreferenceHelper.setUserLoggedIn();
        hideProgressBar();
        doAfterLoginSuccessWork();


    }

    private void doAfterLoginSuccessWork() {
        // opening Activity on Login Success

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onLoginFailed() {
        // this function is called after controller give response to failure

        hideProgressBar();

    }

    private void showProgressBar() {
        // show progress bar

        if (progressBar != null) {
            progressBar.setVisibility(View.VISIBLE);
        }
    }


    private void hideProgressBar() {
        // hide progress bar

        if (progressBar != null) {
            progressBar.setVisibility(View.INVISIBLE);
        }
    }


}