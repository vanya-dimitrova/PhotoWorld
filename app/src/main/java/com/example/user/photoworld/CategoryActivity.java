package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.view.View;

import com.example.user.photoworld.model.Photo;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.user.photoworld.MainActivity.gallery;


public class CategoryActivity extends AppCompatActivity {

    private LinearLayout linLayout;
    private LinearLayout newLayout;
    private ImageView photo;
    private Toolbar toolbar;
    private ScrollView scroller;

    private HashMap<Photo.Category, ArrayList<Photo>> photos;
    private ArrayList<Photo> photosByCategory;
    private Photo.Category category;

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Greshka", "on resume");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        scroller = (ScrollView) findViewById(R.id.scroll_category);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        category = (Photo.Category) getIntent().getSerializableExtra("category");
        gallery.addPhoto(category, new Photo("Pencho", R.drawable.abstraction_1, "ooo", category));
        gallery.addPhoto(category, new Photo("Vancho", R.drawable.abstraction_2, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.abstraction_3, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.animal, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.b_white, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.flower, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.macro, "ooo", category));
        getSupportActionBar().setTitle("Category");


        this.photos = gallery.photos;
        photosByCategory = this.photos.get(category);

        int size = photosByCategory.size();
        linLayout = (LinearLayout) findViewById(R.id.linear_scrollviewChild);

        if (size != 0) {
            int x = 0;
            for (int i = 0; i < (size + 1) / 2; i++) {
                newLayout = new LinearLayout(this);
                newLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams lLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                newLayout.setLayoutParams(lLParams);
                newLayout.setPadding(10, 10, 10, 10);
                linLayout.addView(newLayout);

                for (int j = 0; j < 2; j++) {
                    if (photosByCategory.get(x) != null) {
                        photo = new ImageView(this);
                        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT);
                        photo.setLayoutParams(param);
                        param.weight = 1.0f;
                        photo.setMaxHeight(130);
                        photo.setAdjustViewBounds(true);
                        photo.setImageResource(photosByCategory.get(x).photoId);
                        final Photo photoToVisualise = photosByCategory.get(x);
                        photo.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent(CategoryActivity.this, PhotoViewActivity.class);
                                intent.putExtra("photo", photoToVisualise);
                                CategoryActivity.this.startActivity(intent);
                            }
                        });
                        newLayout.addView(photo);
                        x++;
                    }
                }
                Log.e("greshka", "sled for");
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Greshka", "on start");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_my_gallery, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.item_profile:
                startActivity(new Intent(CategoryActivity.this, ProfileActivity.class));
                return true;
            case R.id.item_upload:
                return true;
            case R.id.item_log_out:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
