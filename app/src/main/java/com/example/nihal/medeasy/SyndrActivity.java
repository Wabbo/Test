package com.example.nihal.medeasy;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.example.nihal.medeasy.Adapters.SynderModelAdapter;
import com.example.nihal.medeasy.Models.SynderModel;
import com.example.nihal.medeasy.widget.CustomDialog;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SyndrActivity extends AppCompatActivity implements CustomDialog.CustomDialogListener  {
    String syndromeS , drugS ;
    RecyclerView recyclerView ;
    List<SynderModel> synderModelList = new ArrayList<>() ;
    SynderModelAdapter adapter = new SynderModelAdapter(synderModelList) ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syndr);

        recyclerView = findViewById(R.id.syndromeRecyclerView) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    //----------------------------------------------------------------------------------------------
        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
    //----------------------------------------------------------------------------------------------
                 openDialog() ;  // method of the dialog

    //----------------------------------------------------------------------------------------------
            }
        });

        // RecyclerViewSwipeItem

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                synderModelList.remove(viewHolder.getAdapterPosition()) ;
                recyclerView.setAdapter(adapter) ;
            }
        }).attachToRecyclerView(recyclerView);
    }

    @Override
    public void applyText(String syndrome, String drug) {
        Date currentTime = Calendar.getInstance().getTime();
        SimpleDateFormat dateFormat = new SimpleDateFormat(" EEE, d MMM yyyy , HH:mm a");
        String output = dateFormat.format(currentTime);
        SynderModel model = new SynderModel(syndrome,drug,output/*"30/5/2010"*/) ;
        synderModelList.add(model) ;
        recyclerView.setAdapter(adapter) ;

    }

    // method of the dialog
    private void openDialog() {
        CustomDialog customDialog = new CustomDialog() ;
        customDialog.show(getSupportFragmentManager(),"CustomDialogTest");


    }

}
