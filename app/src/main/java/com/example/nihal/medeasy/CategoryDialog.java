package com.example.nihal.medeasy;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.example.nihal.medeasy.Adapters.CategoriesAdapter;
import com.example.nihal.medeasy.Adapters.CategoriesAdapter;
import com.example.nihal.medeasy.Models.CategoriesModel;

import java.util.ArrayList;

public class CategoryDialog extends Dialog {
    public Context a;
    public Dialog dialog;

    public CategoryDialog(Context a) {
        super(a);
        this.a = a;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog=this;
        setContentView(R.layout.add_categories);

        // start add category
        ArrayList<CategoriesModel> categories = new ArrayList<>();

        String category[] = {"Sport","Healthy Food","Music","Yoga","Diet"};
        String category1[] = {"0","1","0","0","1"};

        for(int i = 0; i < category.length; i++){
            CategoriesModel categoriesModel = new CategoriesModel(category[i],category1[i]);
            categories.add(categoriesModel);
        }
        RecyclerView recyclerView =  findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(a, LinearLayoutManager.VERTICAL,false));
        CategoriesAdapter categoriesAdapter = new CategoriesAdapter(categories,a);
        recyclerView.setAdapter(categoriesAdapter);
    }
}
