package com.microsoft.projectoxford.face.samples.ui;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.projectoxford.face.samples.R;

//import android.support.v7.app.AppCompatActivity;

public class TreatmentActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    TextView Disclaimer;
    TextView WhatIsDepression;
    Button MainMenu;
    Button BtnExercise;
    Button BtnDiet;



    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.depressiontest.R.layout.activity_treatment);

        drawerLayout = (DrawerLayout) findViewById(com.example.android.depressiontest.R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, com.example.android.depressiontest.R.string.open, com.example.android.depressiontest.R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(com.example.android.depressiontest.R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);



        //Disclaimer = findViewById(R.id.infoDisclaimer);
        //WhatIsDepression = findViewById(R.id.DefineDepression);
        //MainMenu = findViewById(R.id.MainMenu);
        BtnExercise = findViewById(com.example.android.depressiontest.R.id.btnExercise);
        BtnDiet = findViewById(com.example.android.depressiontest.R.id.btnDiet);



        //MainMenu.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                //Intent i = new Intent(getApplicationContext(), MainActivity.class);
                //startActivity(i);
            //}
        //});

        BtnExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ExercisePageActivity.class);
                startActivity(i);
            }
        });
        BtnDiet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FoodPageActivity.class);
                startActivity(i);
            }
        });


    }
    public void browser1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.nimh.nih.gov/health/publications/depression/index.shtml#pub6"));
        startActivity(browserIntent);
    }

    public void browser2(View view){
        Intent browser2Intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moodjuice.scot.nhs.uk/depression.asp"));
        startActivity(browser2Intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if ( actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Intent intent;

        switch (item.getItemId()) {
            case R.id.nav_account:
                Log.i("MenuItem", "Account");
                intent = new Intent(getApplicationContext(), UserActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_settings:
                Log.i("MenuItem", "About");
                intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                break;

            case R.id.nav_homepage:
                Log.i("MenuItem", "Home");
                intent = new Intent(getApplicationContext(), Homepage.class);
                startActivity(intent);
                break;

            case R.id.nav_logout:
                Log.i("MenuItem", "Logout");
                FirebaseAuth.getInstance().signOut();//logout
                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();
                break;

            default:
                return false;
        }

        return false;
    }
}