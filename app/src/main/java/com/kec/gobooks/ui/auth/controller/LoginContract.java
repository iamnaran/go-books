package com.kec.gobooks.ui.auth.controller;

import com.kec.gobooks.models.Login;

public interface LoginContract {

    void onLoginResponseSuccess(Login login);

    void onLoginFailed();
}
