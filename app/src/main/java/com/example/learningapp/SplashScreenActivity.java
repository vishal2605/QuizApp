package com.example.learningapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreenActivity extends AppCompatActivity {
        ImageView logo;
        TextView title,slogan;
        Animation topanim,bottom_animation,bottom_2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
            setContentView(R.layout.splash_screen);

            logo=findViewById(R.id.logo);
            title=findViewById(R.id.title);
            slogan=findViewById(R.id.slogan);

            topanim= AnimationUtils.loadAnimation(this,R.anim.topanim);
            bottom_animation=AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
            bottom_2=AnimationUtils.loadAnimation(this,R.anim.bottom_2);

            logo.setAnimation(topanim);
            title.setAnimation(bottom_animation);
            slogan.setAnimation(bottom_2);
            int SPLASH_SCREEN=3000;
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }, SPLASH_SCREEN);

    }
}