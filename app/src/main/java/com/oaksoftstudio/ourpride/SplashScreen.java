package com.oaksoftstudio.ourpride;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    ImageView logo;
    Animation Splash_bottom;
    private boolean shouldChangeStatusBarTintToDark;

    @SuppressLint({"ObsoleteSdkInt", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for full screen

        /* this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
        setContentView(R.layout.activity_splash_screen);

//getWindow().setStatusBarColor(Color.parseColor("#000000"));

        //StatusBar icon color change=====
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { View decor = getWindow().getDecorView();

            if (shouldChangeStatusBarTintToDark) { decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            }
            else {
                decor.setSystemUiVisibility(0); } }
        getWindow().setStatusBarColor(Color.parseColor("#050d14"));
        getWindow().setNavigationBarColor(Color.parseColor("#050d14"));


        logo = findViewById(R.id.logo);

        Splash_bottom = AnimationUtils.loadAnimation(SplashScreen.this, R.anim.fade_in);



        logo.setAnimation(Splash_bottom);


        Handler handlerNxt = new Handler();
        handlerNxt.postDelayed(new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(SplashScreen.this,MainActivity.class));
                finish();

            }
        }, 2200);







    }
}