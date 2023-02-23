package com.example.shop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.shop.entity.Category;

public class DetailCategoryActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_category);
        Category category = (Category) getIntent().getSerializableExtra("category");

        TextView title = findViewById(R.id.titleDetail);
        ImageView thumbnail = findViewById(R.id.iconDetail);
        TextView content = findViewById(R.id.content);
//
        title.setText(category.getName());
        thumbnail.setImageResource(category.getIcon());
        content.setText(category.getPhone());

        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickRequestPermission();
            }
        });
    }

    private void clickRequestPermission(){
        if (ContextCompat.checkSelfPermission(DetailCategoryActivity.this,
                Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED) {
            // Permission is already granted, make the phone call
            makePhoneCall();
        } else {
            // Permission is not granted, request it
            ActivityCompat.requestPermissions(DetailCategoryActivity.this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    MY_PERMISSIONS_REQUEST_CALL_PHONE);
        }
    }
    // Handle the result of the permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        if (requestCode == MY_PERMISSIONS_REQUEST_CALL_PHONE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, make the phone call
                makePhoneCall();
            } else {
                // Permission denied, show a message or do something else
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    // Helper method to make the phone call
    private void makePhoneCall() {
        Category category = (Category) getIntent().getSerializableExtra("category");

        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:"+category.getPhone()));
        startActivity(intent);
    }
}