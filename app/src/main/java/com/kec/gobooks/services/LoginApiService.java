package com.kec.gobooks.services;

import com.kec.gobooks.models.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface LoginApiService {

    // creating api service for login url, which accept email/password parameters
    // Synchronously send the request and return its response.

    @POST("login")
    @FormUrlEncoded
    Call<Login> requestLoginFromServer(@Field("email") String emailAddress, @Field("password") String password);



}
