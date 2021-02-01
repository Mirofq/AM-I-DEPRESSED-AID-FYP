package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.view.ViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.android.depressiontest.ViewDash;
import com.example.android.depressiontest.ViewMed;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.projectoxford.face.samples.R;

//import android.support.v7.app.AppCompatActivity;

public class DietActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnDash;
    private Button btnMedi;
    private ImageView imageDash;
    private ImageView imageMedi;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.depressiontest.R.layout.activity_diet);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        //Buttons
        btnDash = findViewById(com.example.android.depressiontest.R.id.btnDash);
        btnMedi = findViewById(com.example.android.depressiontest.R.id.btnMedi);

        //Images
        imageDash = findViewById(com.example.android.depressiontest.R.id.imgDash);
        imageMedi = findViewById(com.example.android.depressiontest.R.id.imgMedi);

        btnDash.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietActivity.this, ViewDash.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(DietActivity.this, imageDash, ViewCompat.getTransitionName(imageDash));
                startActivity(intent, options.toBundle());
            }
        });

        btnMedi.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DietActivity.this, ViewMed.class);

                ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(DietActivity.this, imageMedi, ViewCompat.getTransitionName(imageMedi));
                startActivity(intent, options.toBundle());
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


