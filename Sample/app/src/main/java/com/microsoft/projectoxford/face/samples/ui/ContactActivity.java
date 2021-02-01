package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.projectoxford.face.samples.R;

public class ContactActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Button btnBefrienders;
    private Button btnMMHA;
    private Button btnSOLS;
    private Button btnMIASA;
    private Button btnWAO;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.depressiontest.R.layout.activity_contact);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Get the application context
        getApplicationContext();

        // Get the widget reference from xml layout
        //LinearLayout mRootLayout = findViewById(R.id.root_layout);
        btnBefrienders = findViewById(com.example.android.depressiontest.R.id.btnBefrienders);
        btnMMHA = findViewById(com.example.android.depressiontest.R.id.btnMMHA);
        btnSOLS = findViewById(com.example.android.depressiontest.R.id.btnSOLS);
        btnMIASA = findViewById(com.example.android.depressiontest.R.id.btnMIASA);
        btnWAO = findViewById(com.example.android.depressiontest.R.id.btnWAO);

        // Set a click listener for the button
        btnBefrienders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialerBfkl();
            }
        });

        btnMMHA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialerMMHA();
            }
        });

        btnSOLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialerSOLS();
            }
        });

        btnMIASA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialerMIASA();
            }
        });

        btnWAO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialerWAO();
            }
        });

    }
    // Custom method to open dialer app
    protected void openDialerBfkl(){
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent b = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        b.setData(Uri.parse("tel:" + "0376272929"));
        // Start the dialer app activity with number
        startActivity(b);
    }

    protected void openDialerMMHA(){
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent m = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        m.setData(Uri.parse("tel:" + "0327806803"));
        // Start the dialer app activity with number
        startActivity(m);
    }

    protected void openDialerSOLS(){
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent s = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        s.setData(Uri.parse("tel:" + "0189003247"));
        // Start the dialer app activity with number
        startActivity(s);
    }

    protected void openDialerMIASA(){
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent m = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        m.setData(Uri.parse("tel:" + "0379321409"));
        // Start the dialer app activity with number
        startActivity(m);
    }

    protected void openDialerWAO(){
        // Initialize an intent to open dialer app with specified phone number
        // It open the dialer app and allow user to call the number manually
        Intent m = new Intent(Intent.ACTION_DIAL);
        // Send phone number to intent as data
        m.setData(Uri.parse("tel:" + "15999"));
        // Start the dialer app activity with number
        startActivity(m);
    }

    public void browser1(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.befrienders.org.my/"));
        startActivity(browserIntent);
    }

    public void browser2(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.sols247.org/solshealth/"));
        startActivity(browserIntent);
    }

    public void browser3(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://miasa.org.my/"));
        startActivity(browserIntent);
    }

    public void browser4(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://mmha.org.my"));
        startActivity(browserIntent);
    }

    public void browser5(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://bit.ly/2Mo4TFd"));
        startActivity(browserIntent);
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


