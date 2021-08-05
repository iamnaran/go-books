package com.kec.gobooks.ui.login.controller;

import com.kec.gobooks.models.Login;

public interface LoginContract {

    // these are functions which will help us to communicate with views from controller class

    void onLoginResponseSuccess(Login login);

    void onLoginFailed();
}
