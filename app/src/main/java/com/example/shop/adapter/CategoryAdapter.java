package com.example.shop.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shop.model.Category;
import com.example.shop.viewholder.CategoryViewHolder;
import com.example.shop.DetailCategoryActivity;
import com.example.shop.R;

import java.util.List;

public class CategoryAdapter extends  RecyclerView.Adapter<CategoryViewHolder> {
    private Context mContext;
    private List<Category> mCategoryList;

    public CategoryAdapter(Context context, List<Category> categoryList) {
        this.mContext = context;
        this.mCategoryList = categoryList;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        final Category category = mCategoryList.get(position);
        holder.categoryName.setText(category.getName());
        holder.categoryIcon.setImageResource(category.getIcon());
        holder.categoryIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, DetailCategoryActivity.class);
                intent.putExtra("category", category);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}
