package com.microsoft.projectoxford.face.samples.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Activity22 extends AppCompatActivity {
    ImageView gambar;
    TextView judul,harga,deskripsi;

    String data1,data2,data3;
    int images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.depressiontest.R.layout.activity_22);

        gambar = findViewById(com.example.android.depressiontest.R.id.myImages);
        judul = findViewById(com.example.android.depressiontest.R.id.foodname);
        harga = findViewById(com.example.android.depressiontest.R.id.price);
        deskripsi = findViewById(com.example.android.depressiontest.R.id.description);

        getData();
        setData();
    }


    private void getData()
    {
        if(getIntent().hasExtra("myImage") && getIntent().hasExtra("data1") && getIntent().hasExtra("data2") && getIntent().hasExtra("data3"))
        {
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            data3 = getIntent().getStringExtra("data3");
            images = getIntent().getIntExtra("myImage",1);
        }
        else
        {
            Toast.makeText(this,"tidak ada data", Toast.LENGTH_SHORT).show();
        }

    }

    private void setData()
    {
        judul.setText(data1);
        harga.setText(data2);
        deskripsi.setText(data3);
        gambar.setImageResource(images);
    }
}
