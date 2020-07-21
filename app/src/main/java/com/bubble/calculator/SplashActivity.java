package com.bubble.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        ImageView image = findViewById(R.id.imageView);
        TextView logo=findViewById(R.id.app_title);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(SplashActivity.this, CalculatorActivity.class);
                startActivity(intent);
            }
        }, 5000);

        Animation topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        Animation bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        image.setAnimation(topAnim);
        logo.setAnimation(bottomAnim);
    }
}