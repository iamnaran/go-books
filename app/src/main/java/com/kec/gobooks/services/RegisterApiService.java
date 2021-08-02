package com.kec.gobooks.services;

import com.kec.gobooks.models.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface RegisterApiService {

    // creating api service for login url, which accept email/password parameters
    // Synchronously send the request and return its response.

    @POST("register")
    Call<Login> requestLogin(@Field("email") String emailAddress, @Field("password") String password,  @Field("fullName") String fullName);



}
