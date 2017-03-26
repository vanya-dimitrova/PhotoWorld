package com.example.user.photoworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.user.photoworld.model.Photo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;


public class CategoryActivity extends AppCompatActivity {

    ScrollView scroller;
    LinearLayout linLayout;
    ImageView photo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        scroller = (ScrollView) findViewById(R.id.scroll_category);

        Photo.Category category = (Photo.Category) getIntent().getSerializableExtra("category");
        MainActivity.gallery.addPhoto(category, new Photo("Pencho", R.drawable.abstraction_1, "ooo", category));
        MainActivity.gallery.addPhoto(category, new Photo("Vancho", R.drawable.abstraction_2, "ooo", category));
        MainActivity.gallery.addPhoto(category, new Photo("Gencho", R.drawable.abstraction_3, "ooo", category));

        HashMap<Photo.Category, TreeSet<Photo>> photos = MainActivity.gallery.getPhotos();

        TreeSet<Photo> photosByCategory = photos.get(category);
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

                for (int j = 0; j < 2; j++)
                    if (iterator.hasNext()) {
                        photo = new ImageView(this);
                        photo.setMaxHeight(120);
                        photo.setMaxWidth(linLayout.getWidth() / 2);
                        photo.setImageResource(iterator.next().photoId);
                        linLayout.addView(photo);
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


    }
}
