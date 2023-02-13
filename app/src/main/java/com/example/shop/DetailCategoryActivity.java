package com.example.shop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.shop.model.Category;

public class DetailCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);
        Category category = (Category) getIntent().getSerializableExtra("category");

        TextView title = findViewById(R.id.titleDetail);
        ImageView thumbnail = findViewById(R.id.iconDetail);
//
        title.setText(category.getName());
        thumbnail.setImageResource(category.getIcon());
    }
}