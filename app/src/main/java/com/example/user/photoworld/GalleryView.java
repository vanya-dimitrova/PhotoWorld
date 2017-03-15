package com.example.user.photoworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.photoworld.model.PhotoWorld;

public class GalleryView extends AppCompatActivity {

    ImageView nature;
    ImageView abstraction;
    TextView nature_text;
    ImageView animals;
    ImageView sport;
    ImageView food;
    ImageView macro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_view);

        nature = (ImageView) findViewById(R.id.nature);
        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryView.this, MainActivity.class);
                GalleryView.this.startActivity(i);
            }
        });


    }
}
