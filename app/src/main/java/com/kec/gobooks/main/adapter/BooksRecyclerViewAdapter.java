package com.kec.gobooks.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kec.gobooks.R;

import java.util.ArrayList;
import java.util.List;

public class BooksRecyclerViewAdapter extends RecyclerView.Adapter {


    private final String TAG = BooksRecyclerViewAdapter.this.getClass().getSimpleName();


    private List<String> numbersList = new ArrayList<>();


    public BooksRecyclerViewAdapter(List<String> listOfNumbers) {

        this.numbersList = listOfNumbers;

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

        VHBooks vhBooks = (VHBooks) holder;

        String counterValue = numbersList.get(position);
        vhBooks.counterTextView.setText(counterValue);

    }

    // Size of List
    @Override
    public int getItemCount() {
        return numbersList.size();
    }


    private class VHBooks extends RecyclerView.ViewHolder {


        private TextView counterTextView;

        public VHBooks(@NonNull View itemView) {
            super(itemView);

            counterTextView = itemView.findViewById(R.id.tv_counter);
        }
    }

}
