package com.kec.gobooks.ui.main;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import com.kec.gobooks.R;
import com.kec.gobooks.helpers.GoBookActivity;
import com.kec.gobooks.ui.main.adapter.BooksRecyclerViewAdapter;
import com.kec.gobooks.models.Book;
import com.kec.gobooks.ui.main.interfaces.OnItemClick;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends GoBookActivity {


    private final String TAG = MainActivity.this.getClass().getSimpleName();

    private RecyclerView recyclerView;

    private List<Book> listOfBooks = new ArrayList<>();

    private BooksRecyclerViewAdapter booksRecyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        doAddListOfBooks();
        initViews();
        initListener();
        setUpRecyclerView();

    }

    private void doAddListOfBooks() {

        Book book = new Book();
        book.setBookName("Name");
        book.setBookAuthorName("Author Name");
        book.setPrice(1200);

        listOfBooks.add(book);
        listOfBooks.add(book);
        listOfBooks.add(book);


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

        LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);

//        StaggeredGridLayoutManager layoutManager = new GridLayoutManager(MainActivity.this,)

        recyclerView.setLayoutManager(layoutManager);
        booksRecyclerViewAdapter = new BooksRecyclerViewAdapter(listOfBooks);


        recyclerView.setAdapter(booksRecyclerViewAdapter);


        // use

        booksRecyclerViewAdapter.setOnItemClickLister(new OnItemClick() {
            @Override
            public void onCardItemClicked(Book book) {

                //
                // activity
            }
        });



    }

}