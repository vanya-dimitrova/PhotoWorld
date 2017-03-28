package com.example.user.photoworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.user.photoworld.model.Photo;

import java.util.ArrayList;
import java.util.HashMap;

import static com.example.user.photoworld.MainActivity.gallery;


public class CategoryActivity extends AppCompatActivity {

    private LinearLayout linLayout;
    private LinearLayout newLayout;
    private ImageView photo;

    HashMap<Photo.Category, ArrayList<Photo>> photos;
    ArrayList<Photo> photosByCategory;
    Photo.Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        category = (Photo.Category) getIntent().getSerializableExtra("category");
        gallery.addPhoto(category, new Photo("Pencho", R.drawable.abstraction_1, "ooo", category));
        gallery.addPhoto(category, new Photo("Vancho", R.drawable.abstraction_2, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.abstraction_3, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.animal, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.b_white, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.flower, "ooo", category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.macro, "ooo", category));

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
                        photo.setLayoutParams(param);
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
            }
        }
        else{

        }
    }
}
