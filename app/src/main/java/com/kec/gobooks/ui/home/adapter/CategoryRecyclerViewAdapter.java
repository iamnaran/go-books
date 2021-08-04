package com.kec.gobooks.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kec.gobooks.R;

import org.jetbrains.annotations.NotNull;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter {


    public CategoryRecyclerViewAdapter() {

    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_category,parent,false);

        VHCategory vhCategory = new VHCategory(view);

        return vhCategory;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {

        // plot


    }

    @Override
    public int getItemCount() {
        return 10;
    }



    private class VHCategory extends RecyclerView.ViewHolder{

        private TextView categoryTitle;
        private ImageView categoryImageView;


        public VHCategory(@NonNull @NotNull View itemView) {
            super(itemView);

            categoryTitle = itemView.findViewById(R.id.category_title);
            categoryImageView = itemView.findViewById(R.id.category_image_view);


        }
    }

}
