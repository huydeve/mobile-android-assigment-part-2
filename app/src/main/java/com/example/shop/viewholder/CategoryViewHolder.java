package com.example.shop.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.shop.model.Category;
import com.example.shop.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    public ImageView categoryIcon;
    public TextView categoryName;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        categoryIcon = itemView.findViewById(R.id.category_icon);
        categoryName = itemView.findViewById(R.id.category_name);
    }

    public void bind(Category category) {
        categoryIcon.setImageResource(category.getIcon());
        categoryName.setText(category.getName());
    }
}
