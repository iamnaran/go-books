package com.kec.gobooks.controller;


// A controller class to handle programming logical operation & api request for now

import android.view.View;

import com.kec.gobooks.models.Login;
import com.kec.gobooks.services.ApiClient;
import com.kec.gobooks.services.LoginApiService;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginController {


    private WeakReference<LoginContract> loginContractWeakReference;


    public LoginController(WeakReference<LoginContract> loginContractWeakReference) {
        this.loginContractWeakReference = loginContractWeakReference;
    }

    private LoginController.LoginContract getViewContract() throws NullPointerException {

        if (loginContractWeakReference != null) {
            return loginContractWeakReference.get();
        }
        throw new NullPointerException("View is unavailable");

    }



    private void doLoginWork(String email, String password){

        LoginApiService loginApiService = ApiClient.getClient().create(LoginApiService.class);

        loginApiService.requestLoginFromServer(email,password).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                // do success work
                if (getViewContract() != null){

                    if (response.isSuccessful()){
                        getViewContract().onLoginResponseSuccess("Login Success");
                    }
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

                // do failure work
                if (getViewContract() != null){
                    getViewContract().onLoginFailed();

                }


            }
        });



    }


    // communicating with views

    public interface LoginContract {

        void onLoginResponseSuccess(String message);

        void onLoginFailed();

    }

}

