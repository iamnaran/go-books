package com.kec.gobooks.services;

import com.kec.gobooks.models.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginApiService {

    @POST("login")
    Call<Login> requestLogin(@Field("email") String emailAddress, @Field("password") String password);



}
