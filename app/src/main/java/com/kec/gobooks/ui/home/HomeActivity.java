package com.kec.gobooks.ui.home;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.GsonBuilder;
import com.kec.gobooks.R;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.models.Category;
import com.kec.gobooks.models.Login;
import com.kec.gobooks.ui.home.adapter.CategoryRecyclerViewAdapter;
import com.kec.gobooks.ui.home.controller.HomeContract;
import com.kec.gobooks.ui.home.controller.HomeController;
import com.kec.gobooks.ui.profile.ProfileActivity;
import com.kec.gobooks.utils.AppLog;
import com.kec.gobooks.utils.AppToast;
import com.kec.gobooks.utils.CommunicationConstants;
import com.kec.gobooks.utils.PreferenceHelper;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeActivity extends GoBookActivity implements View.OnClickListener , HomeContract {


    private final String TAG = HomeActivity.this.getClass().getSimpleName();
    private TextView titleTextView;
    private CircleImageView ivProfilePicture;

    // views
    private RecyclerView recyclerView;

    // recyclerview adapter
    private CategoryRecyclerViewAdapter categoryRecyclerViewAdapter;


    private HomeController homeController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initViews();
        initListener();
        setUserDetails();
    }


    @Override
    public void initViews() {

        titleTextView = findViewById(R.id.title);
        ivProfilePicture = findViewById(R.id.iv_profile_image);
        recyclerView = findViewById(R.id.recycler_view_home);

    }

    @Override
    public void initListener() {
        ivProfilePicture.setOnClickListener(this);
        homeController = new HomeController(this);

        homeController.getCategoryList();

    }

    private void setUserDetails() {
        if (PreferenceHelper.getLoginResponse() != null) {
            Login loggedInUserDetails = PreferenceHelper.getLoginResponse();
            Glide.with(HomeActivity.this).load(loggedInUserDetails.getUserDetails().getImage()).into(ivProfilePicture);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.iv_profile_image:

                doOpenProfileWork();

                break;
        }
    }

    private void doOpenProfileWork() {
        if (PreferenceHelper.getLoginResponse() != null) {
            Login loggedInUserDetails = PreferenceHelper.getLoginResponse();
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.putExtra(CommunicationConstants.PROFILE_DATA, loggedInUserDetails.getUserDetails().getFirstName());
            startActivity(intent);
        }

    }


    @Override
    public void onCategoryResponseSuccess(Category category) {
        //

        doUpdateRecyclerView(category);

    }

    private void doUpdateRecyclerView(Category category) {

        setUpRecyclerView(category.getData());

    }

    // do recyclerview setup work
    // adapter , list of data, layout manager
    private void setUpRecyclerView(List<Category.Data> dataList) {



        categoryRecyclerViewAdapter = new CategoryRecyclerViewAdapter(dataList, this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(categoryRecyclerViewAdapter);

    }

    @Override
    public void onResponseFailure() {


        AppToast.showToast("Some error occurred. Please request again");

    }
}