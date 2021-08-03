package com.kec.gobooks.ui.login.controller;

import com.kec.gobooks.models.Login;

public interface LoginContract {

    void onLoginResponseSuccess(Login login);

    void onLoginFailed();
}
