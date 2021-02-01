package com.example.android.depressiontest;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class FoodInfo extends AppCompatActivity {

    AnimationDrawable dietAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foodinfo);

        //Run
        ImageView imageView6 = (ImageView) findViewById(R.id.imagefood);
        imageView6.setBackgroundResource(R.drawable.animation_diet);
        dietAnimation = (AnimationDrawable) imageView6.getBackground();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        dietAnimation.start();


    }
}
