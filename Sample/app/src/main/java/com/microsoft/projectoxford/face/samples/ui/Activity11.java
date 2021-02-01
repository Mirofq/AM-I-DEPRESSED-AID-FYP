package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.projectoxford.face.samples.R;

public class Activity11 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView r1;
    String s1[], s2[], s3[];
    int imageResource[] = {com.example.android.depressiontest.R.drawable.greenteapot, com.example.android.depressiontest.R.drawable.chocolate, com.example.android.depressiontest.R.drawable.yogurt, com.example.android.depressiontest.R.drawable.ginger, com.example.android.depressiontest.R.drawable.egg, com.example.android.depressiontest.R.drawable.tea, com.example.android.depressiontest.R.drawable.sesame, com.example.android.depressiontest.R.drawable.bananapic};
    MenuAdapter adapter;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.depressiontest.R.layout.activity_11);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        r1 = (RecyclerView) findViewById(com.example.android.depressiontest.R.id.myRecycler1);
        s1 = getResources().getStringArray(com.example.android.depressiontest.R.array.haechan_cooking);
        s2 = getResources().getStringArray(com.example.android.depressiontest.R.array.price1);
        s3 = getResources().getStringArray(com.example.android.depressiontest.R.array.description1);
        adapter = new MenuAdapter(this, s1, s2, s3, imageResource);

        r1.setAdapter(adapter);
        r1.setLayoutManager(new LinearLayoutManager(this));

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
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
                break;

            default:
                return false;
        }

        return false;

    }
}