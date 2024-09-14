package com.oaksoftstudio.ourpride;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    FrameLayout framelayout_container;


    //bottom_nav
    LinearLayout home_btn,shohid_btn,enemy_btn,news_btn;
    TextView home_txt,shohid_txt,enemy_txt,news_txt;

LinearLayout dataAdd;
    RelativeLayout toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().setStatusBarColor(Color.parseColor("#091A2A"));



// bottom nav

        dataAdd = findViewById(R.id.dataAdd);
        dataAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSdlFYOtnTodBvkIjWSA9Vw6h882cLTzgAd9lMQ1v69ZOK4x7A/viewform"));
                startActivity(intent);
            }
        });








        toolbar = findViewById(R.id.toolbar);









        framelayout_container = findViewById(R.id.framelayout_container);


        home_txt = findViewById(R.id.home_txt);
        shohid_txt = findViewById(R.id.shohid_txt);
        enemy_txt = findViewById(R.id.enemy_txt);
        news_txt = findViewById(R.id.news_txt);

        home_btn = findViewById(R.id.home_btn);
        shohid_btn = findViewById(R.id.shohid_btn);
        enemy_btn = findViewById(R.id.enemy_btn);
        news_btn = findViewById(R.id.news_btn);


        // for selected home lay
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.framelayout_container, new HomeFragment());
        ft.commit();

        home_txt.setTextColor(Color.parseColor("#F44336"));
        home_btn.setBackgroundColor(Color.parseColor("#050d14"));


        //===============================


        home_btn.setOnClickListener(view ->{

            FragmentManager fm_home = getSupportFragmentManager();
            FragmentTransaction ft_home = fm_home.beginTransaction();
            ft_home.replace(R.id.framelayout_container, new HomeFragment());
            ft_home.commit();

            toolbar.setVisibility(View.VISIBLE);

            home_txt.setTextColor(Color.parseColor("#F44336"));
            shohid_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            enemy_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            news_txt.setTextColor(Color.parseColor("#99FFFFFF"));

            home_btn.setBackgroundColor(Color.parseColor("#050d14"));
            shohid_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            enemy_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            news_btn.setBackgroundColor(Color.parseColor("#091A2A"));

           // Animatoo.INSTANCE.animateSlideLeft(MainActivity.this);


        });

        shohid_btn.setOnClickListener(view ->{

            FragmentManager dashboard_frag = getSupportFragmentManager();
            FragmentTransaction dashboard_fragTran = dashboard_frag.beginTransaction();
            dashboard_fragTran.replace(R.id.framelayout_container, new ShohidFragment());
            dashboard_fragTran.commit();

            toolbar.setVisibility(View.GONE);

            home_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            shohid_txt.setTextColor(Color.parseColor("#F44336"));
            enemy_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            news_txt.setTextColor(Color.parseColor("#99FFFFFF"));

            home_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            shohid_btn.setBackgroundColor(Color.parseColor("#050d14"));
            enemy_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            news_btn.setBackgroundColor(Color.parseColor("#091A2A"));


        });

        enemy_btn.setOnClickListener(view ->{

            FragmentManager dashboard_frag = getSupportFragmentManager();
            FragmentTransaction dashboard_fragTran = dashboard_frag.beginTransaction();
            dashboard_fragTran.replace(R.id.framelayout_container, new EnemyFragment());
            dashboard_fragTran.commit();

            toolbar.setVisibility(View.GONE);

            home_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            shohid_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            enemy_txt.setTextColor(Color.parseColor("#F44336"));
            news_txt.setTextColor(Color.parseColor("#99FFFFFF"));

            home_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            shohid_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            enemy_btn.setBackgroundColor(Color.parseColor("#050d14"));
            news_btn.setBackgroundColor(Color.parseColor("#091A2A"));



        });

        news_btn.setOnClickListener(view ->{

            FragmentManager dashboard_frag = getSupportFragmentManager();
            FragmentTransaction dashboard_fragTran = dashboard_frag.beginTransaction();
            dashboard_fragTran.replace(R.id.framelayout_container, new NewsFragment());
            dashboard_fragTran.commit();

            toolbar.setVisibility(View.GONE);

            home_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            shohid_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            enemy_txt.setTextColor(Color.parseColor("#99FFFFFF"));
            news_txt.setTextColor(Color.parseColor("#F44336"));

            home_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            shohid_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            enemy_btn.setBackgroundColor(Color.parseColor("#091A2A"));
            news_btn.setBackgroundColor(Color.parseColor("#050d14"));




        });



// bottom nav







    }//=======================



}//============================
