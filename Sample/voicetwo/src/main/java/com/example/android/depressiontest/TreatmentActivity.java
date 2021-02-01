package com.example.android.depressiontest;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
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
import com.google.firebase.firestore.FirebaseFirestore;

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
        setContentView(R.layout.activity_treatment);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);



        //Disclaimer = findViewById(R.id.infoDisclaimer);
        //WhatIsDepression = findViewById(R.id.DefineDepression);
        //MainMenu = findViewById(R.id.MainMenu);
        BtnExercise = findViewById(R.id.btnExercise);
        BtnDiet = findViewById(R.id.btnDiet);



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
        Intent intent = new Intent(Intent.ACTION_MAIN);

        int itemId = item.getItemId();

        if (itemId == R.id.nav_account) {
            Log.i("MenuItem", "Account");
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.UserActivity"));
            startActivity(intent);

        } else if (itemId == R.id.nav_settings) {
            Log.i("MenuItem", "About");
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.AboutActivity"));
            startActivity(intent);

        } else if (itemId == R.id.nav_homepage) {
            Log.i("MenuItem", "Homepage");
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.Homepage"));
            startActivity(intent);

        } else if (itemId == R.id.nav_logout) {
            Log.i("MenuItem", "Logout");

            FirebaseAuth.getInstance().signOut();//logout
            intent.setComponent(new ComponentName("com.microsoft.projectoxford.face.samples", "com.microsoft.projectoxford.face.samples.ui.LoginActivity"));
            finish();
        } else {
            return false;
        }

        return false;
    }
}
