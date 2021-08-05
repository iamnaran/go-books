package com.kec.gobooks.ui.home.controller;

import com.kec.gobooks.models.Category;
import com.kec.gobooks.models.Login;

public interface HomeContract {

    void onCategoryResponseSuccess(Category category);

    void onResponseFailure();



}
