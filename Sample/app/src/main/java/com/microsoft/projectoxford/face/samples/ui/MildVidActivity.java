package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.android.depressiontest.VideoPlayerActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.microsoft.projectoxford.face.samples.R;
import com.squareup.picasso.Picasso;

public class MildVidActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    String[] vdourlkey = new String[]{
            "vParKngwgI8","iNsSl2jjuf4","sFtP0HWvu0k"
    };
    int length = vdourlkey.length;
    String thumbnailurl1 = "https://img.youtube.com/vi/";
    String thumbnailurl2 = "/hqdefault.jpg";
    String[] ListviewTitle = new String[]{
            "BREATHING EXERCISE","YOGA EXERCISE","SIMPLE WORKOUT"
    };

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(com.example.android.depressiontest.R.layout.activity_mildvid);

        drawerLayout = (DrawerLayout) findViewById(R.id.DrawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView)findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);


        listView=findViewById(com.example.android.depressiontest.R.id.playlist);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MildVidActivity.this, VideoPlayerActivity.class);
                intent.putExtra("url", vdourlkey[position]);
                startActivity(intent);
            }
        });
    }
    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=getLayoutInflater().inflate(com.example.android.depressiontest.R.layout.customlist, null);
            ImageView imageView = view.findViewById(com.example.android.depressiontest.R.id.imagelist);
            TextView textView = view.findViewById(com.example.android.depressiontest.R.id.titlelist);
            Picasso.get().load(thumbnailurl1+vdourlkey[position]+thumbnailurl2).into(imageView);
            textView.setText(ListviewTitle[position]);
            return view;
        }
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
