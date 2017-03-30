package com.example.user.photoworld.photoGallery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.user.photoworld.R;
import com.example.user.photoworld.registration_login_profile.MainActivity;
import com.example.user.photoworld.registration_login_profile.UploadDialogActivity;
import com.example.user.photoworld.adapters.MyRecyclerViewAdapter;
import com.example.user.photoworld.registration_login_profile.LogoutDialogActivity;
import com.example.user.photoworld.registration_login_profile.ProfileActivity;

import java.util.ArrayList;
import java.util.List;

public class MyGalleryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private  MenuItem logOut;
    private  MenuItem upload;
    private  MenuItem profile;

    RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gallery);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logOut = (MenuItem) findViewById(R.id.item_log_out);
        upload = (MenuItem) findViewById(R.id.item_upload);
        profile = (MenuItem) findViewById(R.id.item_profile);
        rView = (RecyclerView) findViewById(R.id.my_recycler_view);

        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);


        List<MyRecyclerViewAdapter.CategoryHelp> categories = new ArrayList<>();

        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.abstraction, "Abstraction"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.animal, "Animal"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.b_white, "Black&White"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.flower, "Flower"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.food, "Food"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.macro, "Macro"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.nature, "Nature"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.pattern, "Pattern"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.people, "People"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.portrait, "Portrait"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.sport, "Sport"));
        categories.add(new MyRecyclerViewAdapter.CategoryHelp(R.drawable.vintage, "Vintage"));

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(MyGalleryActivity.this, categories);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.VERTICAL, false));
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
                Intent intent = new Intent(MyGalleryActivity.this, ProfileActivity.class);
                intent.putExtra("user", MainActivity.gallery.currentUser);
                startActivity(intent);
                return true;
            case R.id.item_upload:
                intent = new Intent(MyGalleryActivity.this, UploadDialogActivity.class);
                intent.putExtra("user", MainActivity.gallery.currentUser);
                startActivity(intent);
                return true;
            case R.id.item_log_out:
                startActivity(new Intent(MyGalleryActivity.this, LogoutDialogActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
