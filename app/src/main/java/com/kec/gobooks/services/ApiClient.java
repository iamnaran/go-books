package com.kec.gobooks.services;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kec.gobooks.utils.PreferenceHelper;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static final String BASE_URL = "https://elibrary.smartgov.app/api/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {

        // to strictly follow json syntax
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        // Logging Object

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        // creating custom okhttp plus adding time out for request
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient httpClient = builder
                .addInterceptor(interceptor)
                .addInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {

                        Request request = chain.request();
                        if (PreferenceHelper.getLoginResponse() != null) {
                            if (TextUtils.isEmpty(PreferenceHelper.getLoginResponse().getUserDetails().getToken())) {
                                return chain.proceed(request);
                            }

                        }

                        request = request.newBuilder()
                                .addHeader("Authorization", PreferenceHelper.getLoginResponse().getUserDetails().getToken())
                                .addHeader("Accept", "Accept: application/x.school.v1+json")
                                .build();

                        Response response = chain.proceed(request);
                        return response;

                    }
                })
                .readTimeout(60, TimeUnit.SECONDS)
                .connectTimeout(60, TimeUnit.SECONDS).build();

        // returning retrofit object with their credentials
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(httpClient)
                    .build();
        }
        // return retrofit with all above configuration
        return retrofit;
    }

}
