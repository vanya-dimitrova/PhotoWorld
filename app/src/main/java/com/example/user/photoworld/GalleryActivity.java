package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.user.photoworld.model.Photo;


public class GalleryActivity extends AppCompatActivity {

    private ImageView abstractionImage;
    private ImageView animalImage;
    private ImageView blackWhiteImage;
    private ImageView flowerImage;
    private ImageView foodImage;
    private ImageView macroImage;
    private ImageView natureImage;
    private ImageView patternImage;
    private ImageView peopleImage;
    private ImageView portraitImage;
    private ImageView sportImage;
    private ImageView vintageImage;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        setSupportActionBar(toolbar);

        abstractionImage = (ImageView) findViewById(R.id.abstraction_image);
        abstractionImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.ABSTRACT);
                GalleryActivity.this.startActivity(i);
            }
        });


        animalImage = (ImageView) findViewById(R.id.animal_image);
        animalImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.ANIMAL);
                GalleryActivity.this.startActivity(i);
            }
        });

        blackWhiteImage = (ImageView) findViewById(R.id.black_and_white_image);
        blackWhiteImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.BLACK_AND_WHITE);
                GalleryActivity.this.startActivity(i);
            }
        });

        flowerImage = (ImageView) findViewById(R.id.flower_image);
        flowerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.FLOWER);
                GalleryActivity.this.startActivity(i);
            }
        });

        foodImage = (ImageView) findViewById(R.id.food_image);
        foodImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.FOOD);
                GalleryActivity.this.startActivity(i);
            }
        });

        macroImage = (ImageView) findViewById(R.id.macro_image);
        macroImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.MACRO);
                GalleryActivity.this.startActivity(i);
            }
        });

        natureImage = (ImageView) findViewById(R.id.nature_image);
        natureImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.NATURE);
                GalleryActivity.this.startActivity(i);
            }
        });

        patternImage = (ImageView) findViewById(R.id.pattern_image);
        patternImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.PATTERN);
                GalleryActivity.this.startActivity(i);
            }
        });

        peopleImage = (ImageView) findViewById(R.id.people_image);
        peopleImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.PEOPLE);
                GalleryActivity.this.startActivity(i);
            }
        });

        portraitImage = (ImageView) findViewById(R.id.portrait_image);
        portraitImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.PORTRAIT);
                GalleryActivity.this.startActivity(i);
            }
        });

        sportImage = (ImageView) findViewById(R.id.sport_image);
        sportImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.SPORT);
                GalleryActivity.this.startActivity(i);
            }
        });

        vintageImage = (ImageView) findViewById(R.id.vintage_image);
        vintageImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryActivity.this, CategoryActivity.class);
                i.putExtra("category", Photo.Category.VINTAGE);
                GalleryActivity.this.startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_profile:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.item_my_gallery:
                return true;
            case R.id.item_upload:
                return true;
            case R.id.item_log_out:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
