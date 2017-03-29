package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MyGalleryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private  MenuItem logOut;
    private  MenuItem upload;
    private  MenuItem myGallery;
    private  MenuItem profile;

    RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_gallery);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        logOut = (MenuItem) findViewById(R.id.item_logout);
        upload = (MenuItem) findViewById(R.id.item_uploady);
        myGallery = (MenuItem) findViewById(R.id.item_gallery);
        profile = (MenuItem) findViewById(R.id.item_my_profile);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        rView = (RecyclerView) findViewById(R.id.my_recycler_view);

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
                startActivity(new Intent(MyGalleryActivity.this, MyGalleryActivity.class));
                finish();
                return true;
            case R.id.item_my_gallery:
                startActivity(new Intent(MyGalleryActivity.this, MyGalleryActivity.class));
                finish();
                return true;
            case R.id.item_upload:
                return true;
            case R.id.item_log_out:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
