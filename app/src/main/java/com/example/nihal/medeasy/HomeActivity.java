package com.example.nihal.medeasy;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.nihal.medeasy.widget.CanaroTextView;
import com.yalantis.guillotine.animation.GuillotineAnimation;

public class HomeActivity extends AppCompatActivity {
    private static final long RIPPLE_DURATION = 250;
    Toolbar toolbar;
    FrameLayout root;
    View contentHamburger;
    CanaroTextView addCategory,addSyndr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar=findViewById(R.id.toolbar);
        root=findViewById(R.id.root);
        contentHamburger=findViewById(R.id.guillotine_icon_nav);






        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setTitle(null);
        }

        View guillotineMenu = LayoutInflater.from(this).inflate(R.layout.guillotine, null);

        //here will cntrol galilio items
        LinearLayout test=guillotineMenu.findViewById(R.id.ctyg_section);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoryDialog categoryDialog = new CategoryDialog(HomeActivity.this);
                categoryDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                categoryDialog.show();
            }
        });

        //go to synder
        LinearLayout test1=guillotineMenu.findViewById(R.id.synd_section);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,SyndrActivity.class));
            }
        });



        //here will be initila galilio

        root.addView(guillotineMenu);

        new GuillotineAnimation.GuillotineBuilder(guillotineMenu, guillotineMenu.findViewById(R.id.guillotine_icon_nav), contentHamburger)
                .setStartDelay(RIPPLE_DURATION)
                .setActionBarViewForAnimation(toolbar)
                .setClosedOnStart(true)
                .build();
    }
}
