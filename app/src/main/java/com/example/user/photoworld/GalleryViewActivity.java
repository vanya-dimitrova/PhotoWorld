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
import android.widget.TextView;

public class GalleryViewActivity extends AppCompatActivity {

    private ImageView nature;
    private ImageView abstraction;
    private TextView nature_text;
    private ImageView animals;
    private ImageView sport;
    private ImageView food;
    private ImageView macro;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_view);

        setSupportActionBar(toolbar);

        nature = (ImageView) findViewById(R.id.nature);
        nature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GalleryViewActivity.this, MainActivity.class);
                GalleryViewActivity.this.startActivity(i);
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
