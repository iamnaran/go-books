package com.kec.gobooks.services;

import com.kec.gobooks.models.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetCategoryApiService {

    // creating api service for login url, which accept email/password parameters
    // Synchronously send the request and return its response.

    @GET("category")
    Call<Login> requestLogin(@Field("email") String emailAddress, @Field("password") String password);



}
