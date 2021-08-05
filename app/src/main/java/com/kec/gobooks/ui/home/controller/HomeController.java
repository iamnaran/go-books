package com.kec.gobooks.ui.home.controller;

import com.kec.gobooks.models.Category;
import com.kec.gobooks.services.ApiClient;
import com.kec.gobooks.services.CategoryApiService;
import com.kec.gobooks.ui.login.controller.LoginContract;

import java.lang.ref.WeakReference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeController {


    private WeakReference<HomeContract> homeContractWeakReference;

    public HomeController(HomeContract homeContract) {
        this.homeContractWeakReference = new WeakReference<>(homeContract);
    }

    // return view instance when view is not null, else throw runtime exception.

    private HomeContract getViewContract() throws NullPointerException {
        if (homeContractWeakReference != null) {
            return homeContractWeakReference.get();
        }
        throw new NullPointerException("View is unavailable");

    }

    public void getCategoryList() {

        CategoryApiService categoryApiService = ApiClient.getClient().create(CategoryApiService.class);

        categoryApiService.requestCategory().enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {

                if (response.isSuccessful()){

                    if (getViewContract() != null){
                        getViewContract().onCategoryResponseSuccess();
                    }
                }

            }

            @Override
            public void onFailure(Call<Category> call, Throwable t) {

                if (getViewContract() != null){

                    getViewContract().onResponseFailure();

                }

            }
        });


    }



}
