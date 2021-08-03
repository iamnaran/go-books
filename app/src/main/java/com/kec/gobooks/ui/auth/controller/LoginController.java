package com.kec.gobooks.ui.auth.controller;

import com.kec.gobooks.models.Login;
import com.kec.gobooks.services.ApiClient;
import com.kec.gobooks.services.LoginApiService;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// A controller class to handle programming logical operation & api request for now

public class LoginController {



    /*
      About WeakReference
      Suppose that the garbage collector determines at a certain point in time
      that an object is weakly reachable. At that time it will atomically clear all weak references to
      that object and all weak references to any other weakly-reachable objects
      from which that object is reachable through a chain of strong and soft
      references.
      */

    private WeakReference<LoginContract> loginContractWeakReference;

    public LoginController(LoginContract loginContractWeakReference) {
        this.loginContractWeakReference = new WeakReference<>(loginContractWeakReference);
    }

    private LoginContract getViewContract() throws NullPointerException {

        if (loginContractWeakReference != null) {
            return loginContractWeakReference.get();
        }
        throw new NullPointerException("View is unavailable");

    }

    //
    public void doLoginWork(String email, String password) {

        LoginApiService loginApiService = ApiClient.getClient().create(LoginApiService.class);

        loginApiService.requestLoginFromServer(email, password).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                // do success work
                if (getViewContract() != null) {

                    if (response.isSuccessful()) {
                        getViewContract().onLoginResponseSuccess(response.body());
                    }else {
                        getViewContract().onLoginFailed();
                    }
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

                // do failure work
                if (getViewContract() != null) {
                    getViewContract().onLoginFailed();

                }


            }
        });


    }

}

