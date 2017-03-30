package com.example.user.photoworld.photoGallery;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.user.photoworld.R;
import com.example.user.photoworld.adapters.MyRecyclerViewAdapter2;
import com.example.user.photoworld.model.Photo;
import com.example.user.photoworld.registration_login_profile.LogoutDialogActivity;
import com.example.user.photoworld.registration_login_profile.MainActivity;
import com.example.user.photoworld.registration_login_profile.ProfileActivity;
import com.example.user.photoworld.registration_login_profile.UploadDialogActivity;

import java.util.List;

import static com.example.user.photoworld.registration_login_profile.MainActivity.gallery;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private MenuItem logOut;
    private MenuItem upload;
    private MenuItem profile;
    RecyclerView rv;

    List<Photo> categoryPhotos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logOut = (MenuItem) findViewById(R.id.item_log_out);
        upload = (MenuItem) findViewById(R.id.item_upload);
        profile = (MenuItem) findViewById(R.id.item_profile);

        setSupportActionBar(toolbar);
        rv = (RecyclerView) findViewById(R.id.my_recycler_view2);

        Photo.Category category = (Photo.Category) getIntent().getSerializableExtra("category");
        getSupportActionBar().setTitle(getString(R.string.app_name) + " " + category.name());

        gallery.addPhoto(category, new Photo("Pencho", R.drawable.abstraction_1, category));
        gallery.addPhoto(category, new Photo("Vancho", R.drawable.abstraction_2, category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.abstraction_3, category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.animal, category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.b_white, category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.flower, category));
        gallery.addPhoto(category, new Photo("Gencho", R.drawable.macro, category));

        categoryPhotos = MainActivity.gallery.photos.get(category);

        MyRecyclerViewAdapter2 adapter2 = new MyRecyclerViewAdapter2(CategoryActivity.this, categoryPhotos);
        rv.setAdapter(adapter2);
        rv.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
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
            case R.id.item_profile:
                Intent intent = new Intent(CategoryActivity.this, ProfileActivity.class);
                intent.putExtra("user", MainActivity.gallery.currentUser);
                startActivity(intent);
                return true;
            case R.id.item_upload:
                intent = new Intent(CategoryActivity.this, UploadDialogActivity.class);
                intent.putExtra("user", MainActivity.gallery.currentUser);
                startActivity(intent);
                return true;
            case R.id.item_log_out:
                startActivity(new Intent(CategoryActivity.this, LogoutDialogActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}


