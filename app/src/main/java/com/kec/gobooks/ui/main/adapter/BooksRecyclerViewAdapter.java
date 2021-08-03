package com.kec.gobooks.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kec.gobooks.R;
import com.kec.gobooks.models.Book;

import java.util.ArrayList;
import java.util.List;

public class BooksRecyclerViewAdapter extends RecyclerView.Adapter {


    private final String TAG = BooksRecyclerViewAdapter.this.getClass().getSimpleName();


    private List<Book> bookList = new ArrayList<>();


    public BooksRecyclerViewAdapter(List<Book> books) {

        this.bookList = books;

    }
    

    // Return Our View Which we want to create

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv_books, parent, false);
        return new VHBooks(itemView);

    }

    // Plot Data In our Views
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        // plotting recyclerview
        Book bookItem = bookList.get(position);
        VHBooks vhBooks = (VHBooks) holder;
        vhBooks.bookName.setText(bookItem.getBookName());
        vhBooks.bookAuthorName.setText(bookItem.getBookAuthorName());



    }

    // Size of List
    @Override
    public int getItemCount() {


        return bookList.size();
    }


    private class VHBooks extends RecyclerView.ViewHolder {


        private TextView bookName;
        private TextView bookAuthorName;

        public VHBooks(@NonNull View itemView) {
            super(itemView);

            bookName = itemView.findViewById(R.id.tv_book_name);
            bookAuthorName = itemView.findViewById(R.id.tv_book_author_name);
        }
    }

}
