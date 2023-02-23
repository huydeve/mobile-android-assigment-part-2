package com.example.shop;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.shop.adapter.ProductAdapter;
import com.example.shop.db.ProductDatabase;
import com.example.shop.entity.Product;
import dao.ProductDao;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement extends AppCompatActivity {
    private RecyclerView mRecyclerProduct;
    private ProductAdapter mProductAdapter ;
    private List<Product> products;
    private ProductDatabase mDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_management);


        mDb = ProductDatabase.getInMemoryDatabase(getApplicationContext());
        products = mDb.getProductsDAO().getAllProducts();
        mProductAdapter = new ProductAdapter(this, products,mDb);

        mRecyclerProduct = findViewById(R.id.recyclerView_product);

//
        Button createBtn = findViewById(R.id.create_btn);
//
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertProduct();
                products.clear();
                products.addAll(mDb.getProductsDAO().getAllProducts());
                mProductAdapter.notifyDataSetChanged();
            }
        });

        mRecyclerProduct.setAdapter(mProductAdapter);
        mRecyclerProduct.setLayoutManager(new LinearLayoutManager(this));
    }
    private void insertProduct() {
        EditText productNameEditText = findViewById(R.id.product_name_create);
        EditText productDescriptionEditText = findViewById(R.id.product_description_create);
        EditText productPriceEditText = findViewById(R.id.product_price_create);
        String name = productNameEditText.getText().toString();
        String description = productDescriptionEditText.getText().toString();
        int price = Integer.parseInt(productPriceEditText.getText().toString());

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        mDb.getProductsDAO().insert(product);


        mProductAdapter.notifyItemInserted(mProductAdapter.getItemCount() - 1);

    }
}