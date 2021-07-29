package com.kec.gobooks.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.kec.gobooks.R;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.main.adapter.BooksRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends GoBookActivity {


    private final String TAG = MainActivity.this.getClass().getSimpleName();

    private RecyclerView recyclerView;

    private List<String> listOfNumbers = new ArrayList<>();

    private BooksRecyclerViewAdapter booksRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listOfNumbers.add(" I am Zero Position");

        for (int i = 0; i < 10; i++) {
            listOfNumbers.add(String.valueOf(i));
        }

        listOfNumbers.add(" I am at Last Position");


        initViews();
        initListener();
        setUpRecyclerView();

    }


    @Override
    public void initViews() {

        recyclerView = findViewById(R.id.recycler_view);

    }

    @Override
    public void initListener() {

    }

    private void setUpRecyclerView() {

        // Layout Manager
        // RecyclerView Adapter
        // List of Items

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(MainActivity.this,
                        RecyclerView.VERTICAL,
                        false);
        recyclerView.setLayoutManager(layoutManager);

        booksRecyclerViewAdapter = new BooksRecyclerViewAdapter(listOfNumbers);

        recyclerView.setAdapter(booksRecyclerViewAdapter);


    }

}