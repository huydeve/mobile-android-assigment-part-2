package com.example.shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.example.shop.ui.main.SectionsPagerAdapter;
import com.example.shop.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        // Set the Toolbar as the action bar
        mToolbar = findViewById(R.id.toolbar);
        mToolbar.setTitle("Shop");
        setSupportActionBar(mToolbar);

        // Inflate the menu resource file
        getMenuInflater().inflate(R.menu.menu_product_list, mToolbar.getMenu());


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_product_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:
                // Handle click on the Search item
                Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cart:
                // Handle click on the Cart item
                Toast.makeText(this, "Cart clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.product_management:
                // Handle click on the Cart item
                startActivity(new Intent(HomeActivity.this, ProductManagement.class));

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}