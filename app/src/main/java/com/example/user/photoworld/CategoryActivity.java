package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.user.photoworld.model.Photo;

import java.util.HashMap;
import java.util.TreeSet;

import static com.example.user.photoworld.MainActivity.gallery;


public class CategoryActivity extends AppCompatActivity {

    private ScrollView scroller;
    private LinearLayout linLayout;
    private ImageView photo;
    private Toolbar toolbar;

    private Photo.Category category;
    private HashMap<Photo.Category, TreeSet<Photo>> photos;
    private TreeSet<Photo> photosByCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        scroller = (ScrollView) findViewById(R.id.scroll_category);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = new Bundle();
        if(bundle != null && bundle.getSerializable("category") != null) {
            category = (Photo.Category) getIntent().getSerializableExtra("category");
            gallery.addPhoto(category, new Photo("Pencho", R.drawable.abstraction_1, "ooo", category));
            gallery.addPhoto(category, new Photo("Vancho", R.drawable.abstraction_2, "ooo", category));
            gallery.addPhoto(category, new Photo("Gencho", R.drawable.abstraction_3, "ooo", category));
            getSupportActionBar().setTitle("Category");
        }
    /*
        photos = gallery.getPhotos();
        photosByCategory = photos.get(category);

        int size = photosByCategory.size();
        if (size != 0) {
            Iterator<Photo> iterator = photosByCategory.iterator();
            for (int i = 0; i < size / 2; i++) {
                linLayout = new LinearLayout(this);
                linLayout.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams lLParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                linLayout.setLayoutParams(lLParams);
                linLayout.setPadding(10, 10, 10, 10);
                scroller.addView(linLayout);

                for (int j = 0; j < 2; j++) {
                    if (iterator.hasNext()) {
                        photo = new ImageView(this);
                        photo.setMaxHeight(120);
                        photo.setMaxWidth(linLayout.getWidth() / 2);
                        photo.setImageResource(iterator.next().photoId);
                        linLayout.addView(photo);
                    }
                }
            }
        } else {
            TextView text = new TextView(this);

            LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            text.setText("Nesto ne e nared");
            text.setTextSize(50);
            text.setLayoutParams(param);
            scroller.addView(text);
        }
    */
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
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.item_profile:
                startActivity(new Intent(CategoryActivity.this, ProfileActivity.class));
                return true;
            case R.id.item_my_gallery:
                startActivity(new Intent(CategoryActivity.this, MyGalleryActivity.class));
                return true;
            case R.id.item_upload:
                return true;
            case R.id.item_log_out:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
