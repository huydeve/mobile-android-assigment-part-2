package com.example.shop.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.shop.R;
import com.example.shop.db.ProductDatabase;
import com.example.shop.entity.*;
import dao.ProductDao;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context mContext;

    private ProductDatabase mDb;

    private List<Product> products;

    public ProductAdapter(Context mContext, List<Product> products, ProductDatabase mDb) {
        this.mContext = mContext;
        this.mDb = mDb;
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
//        ProductDao dao = mDb.getProductsDAO();
        Product product = products.get(position);
        holder.bind(product);


        int pos = holder.getAdapterPosition();



        holder.deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDb.getProductsDAO().delete(product.getId());
                products.remove(pos);
                notifyItemRemoved(pos);
                notifyItemRangeChanged(pos, products.size());
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView mNameTextView;
        public TextView mDescriptionTextView;
        public TextView mPriceTextView;
        public TextView mIdTextView;
        Button deleteButton, updateButton;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            mNameTextView = itemView.findViewById(R.id.product_name);
            mDescriptionTextView = itemView.findViewById(R.id.product_description);
            mPriceTextView = itemView.findViewById(R.id.product_price);
            mIdTextView = itemView.findViewById(R.id.product_id);

            deleteButton = itemView.findViewById(R.id.delete_product_btn);
            updateButton = itemView.findViewById(R.id.update_product_btn);
        }
        public void bind(Product product) {
              mNameTextView.setText(product.getName());
              mDescriptionTextView.setText(product.getDescription());
              mPriceTextView.setText(String.valueOf(product.getPrice()));
//              mIdTextView.setText(product.getId());
        }
    }
}