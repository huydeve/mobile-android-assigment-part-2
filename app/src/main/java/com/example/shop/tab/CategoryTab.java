package com.example.shop.tab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.shop.entity.Category;
import com.example.shop.adapter.CategoryAdapter;
import com.example.shop.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoryTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoryTab extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String tabName;
    private RecyclerView recyclerViewCategories;
    private CategoryAdapter categoryAdapter ;
    private ArrayList<Category> categories ;

    public CategoryTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryTab.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoryTab newInstance(String param1, String param2) {
        CategoryTab fragment = new CategoryTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        categories = new ArrayList<>();
        createList();
        categoryAdapter = new CategoryAdapter(getContext(), categories);
        View view = inflater.inflate(R.layout.fragment_category_tab, container, false);
        recyclerViewCategories = view.findViewById(R.id.recyclerView_categories);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recyclerViewCategories.setLayoutManager(gridLayoutManager);
        recyclerViewCategories.setAdapter(categoryAdapter);


        // Inflate the layout for this fragment
        return view;
    }

    private void createList() {

        categories.add(new Category("Accessories",R.drawable.ic_accessories,"09999999"));
        categories.add(new Category("Accessories",R.drawable.ic_accessories,"09999999"));
        categories.add(new Category("Accessories",R.drawable.ic_accessories,"09999999"));
        categories.add(new Category("Accessories",R.drawable.ic_accessories,"09999999"));
        categories.add(new Category("Accessories",R.drawable.ic_accessories,"09999999"));



    }
}