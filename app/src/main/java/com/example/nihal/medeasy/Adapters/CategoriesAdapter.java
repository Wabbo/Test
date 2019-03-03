package com.example.nihal.medeasy.Adapters;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.nihal.medeasy.Models.CategoriesModel;
import com.example.nihal.medeasy.R;

import java.util.ArrayList;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {
    ArrayList<CategoriesModel> categoriesModelArrayList;
    Context context;

    public CategoriesAdapter(ArrayList<CategoriesModel> categoriesModelArrayList, Context context) {
        this.categoriesModelArrayList = categoriesModelArrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false);
        return new CategoriesAdapter.CategoriesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
        CategoriesModel categoriesModel = categoriesModelArrayList.get(position);
        holder.CategoryName.setText(categoriesModel.getCategoryName());
        if(categoriesModel.getCheckBox().equals("0")){
            holder.checkBox.setChecked(false);
        }
        else holder.checkBox.setChecked(true);


    }

    @Override
    public int getItemCount() {
        return categoriesModelArrayList.size();
    }

    class CategoriesHolder extends RecyclerView.ViewHolder{
        TextView CategoryName;
        CheckBox checkBox;

        public CategoriesHolder(@NonNull View itemView) {
            super(itemView);
            CategoryName = itemView.findViewById(R.id.categoryNamePlace);
            checkBox = itemView.findViewById(R.id.checkbox);

        }
    }

}
