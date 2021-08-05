package com.kec.gobooks.ui.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.kec.gobooks.ui.home.HomeActivity;
import com.kec.gobooks.ui.login.controller.LoginContract;
import com.kec.gobooks.ui.login.controller.LoginController;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.utils.AppToast;
import com.kec.gobooks.utils.PreferenceHelper;

public class LoginActivity extends GoBookActivity implements View.OnClickListener, LoginContract {


    // all elements from ui view
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

                // do validation work

                String editTextEmailValue = emailEditText.getText().toString();
                String editTextPasswordValue = passwordEditText.getText().toString();

                if (editTextEmailValue.isEmpty() || editTextPasswordValue.isEmpty()) {
                    AppToast.showToast("Called");
                    emailEditText.setError("Email fields is mandatory");
                    passwordEditText.setError("Password fields is mandatory");
                    return;
                }
                if (Patterns.EMAIL_ADDRESS.matcher(editTextEmailValue).matches()) {

                    // called when all above validation is correct.

                    showProgressBar();
                    loginController.doLoginWork(editTextEmailValue, editTextPasswordValue);

                } else {

                    showInputFieldRequiredDialog();

                }


                break;


            case R.id.tv_create_new_account:

                // tv sign up called


                break;
        }
    }

    private void showInputFieldRequiredDialog() {

        new AlertDialog.Builder(LoginActivity.this)
                .setTitle("Please input Email & Password")
                .setMessage("Are you sure you want to delete this entry?")

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton("Cancel", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

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

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
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