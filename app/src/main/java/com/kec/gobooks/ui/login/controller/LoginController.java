package com.kec.gobooks.ui.login.controller;

import com.kec.gobooks.models.Login;
import com.kec.gobooks.services.ApiClient;
import com.kec.gobooks.services.LoginApiService;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    /*
      A controller class to handle programming logical operation & api request for now
      About WeakReference
      Suppose that the garbage collector determines at a certain point in time
      that an object is weakly reachable. At that time it will atomically clear all weak references to
      that object and all weak references to any other weakly-reachable objects
      from which that object is reachable through a chain of strong and soft
      references.
      */

public class LoginController {


    // instance of weak reference
    private WeakReference<LoginContract> loginContractWeakReference;

    // constructor where we will provide a weak reference instance of view from other classes
    public LoginController(LoginContract loginContractWeakReference) {
        this.loginContractWeakReference = new WeakReference<>(loginContractWeakReference);
    }



    // return view instance when view is not null, else throw runtime exception.

    private LoginContract getViewContract() throws NullPointerException {

        if (loginContractWeakReference != null) {
            return loginContractWeakReference.get();
        }
        throw new NullPointerException("View is unavailable");

    }

    // Do Network request work & return response success/ error data to other classes where implementation is made.

    public void doLoginWork(String email, String password) {

        // creating login api service , preparing service for next request.
        LoginApiService loginApiService = ApiClient.getClient().create(LoginApiService.class);

        // requesting to server and listen it's callback response.
        loginApiService.requestLoginFromServer(email, password).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {

                // do success work
                if (getViewContract() != null) {
                    if (response.isSuccessful()) {
                        // return success with login object we received
                        getViewContract().onLoginResponseSuccess(response.body());
                    }else {

                        // return failed if in case response has failed somehow.
                        getViewContract().onLoginFailed();
                    }
                }

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

                // do failure work
                if (getViewContract() != null) {
                    // return error or display login has failed.
                    getViewContract().onLoginFailed();

                }


            }
        });

    }

}

