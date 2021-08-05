package com.kec.gobooks.ui.home.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.kec.gobooks.R;
import com.kec.gobooks.models.Category;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CategoryRecyclerViewAdapter extends RecyclerView.Adapter {


    private List<Category.Data> categoryList;

    private Context context;

    public CategoryRecyclerViewAdapter(List<Category.Data> dataList, Context context) {

        this.categoryList = dataList;
        this.context = context;
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

        Category.Data data = categoryList.get(position);
        VHCategory vhCategory = (VHCategory) holder;
        vhCategory.categoryTitle.setText(data.getName());
        Glide.with(vhCategory.categoryImageView.getContext()).load(data.getImage()).into(vhCategory.categoryImageView);

    }

    @Override
    public int getItemCount() {

        if (categoryList != null){

            return categoryList.size();

        }
        return 0;
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
