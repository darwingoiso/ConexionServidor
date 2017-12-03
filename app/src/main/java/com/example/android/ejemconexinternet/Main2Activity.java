package com.example.android.ejemconexinternet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class Main2Activity extends AppCompatActivity {
    ImageView miimagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        miimagen=(ImageView)findViewById(R.id.imageView);
        Picasso.with(getApplicationContext())
                .load("http://www.programadoresperuanos.com/imagenperu.jpg")
                .fit()
                .placeholder(R.drawable.default_img).into(miimagen);
    }
}
