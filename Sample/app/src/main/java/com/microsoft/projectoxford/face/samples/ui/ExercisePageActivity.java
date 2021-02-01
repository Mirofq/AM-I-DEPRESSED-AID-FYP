package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.android.depressiontest.ExerciseInfo;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.projectoxford.face.samples.R;

//import android.support.v7.app.AppCompatActivity;


public class ExercisePageActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Button BtnInfo;
    Button BtnMild;
    Button BtnSevere;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.depressiontest.R.layout.activity_exercisepage);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        BtnInfo = findViewById(com.example.android.depressiontest.R.id.btnExeInfo);
        BtnMild = findViewById(com.example.android.depressiontest.R.id.BtnMild);
        BtnSevere = findViewById(com.example.android.depressiontest.R.id.btnSevere);

        BtnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ExerciseInfo.class);
                startActivity(i);
            }
        });

        BtnMild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b = new Intent(getApplicationContext(), MildVidActivity.class);
                startActivity(b);
            }
        });


        BtnSevere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent w = new Intent(getApplicationContext(), SevereVidActivity.class);
                startActivity(w);
            }
        });
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
