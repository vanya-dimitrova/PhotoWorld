package com.example.user.photoworld;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GalleryGridActivity extends AppCompatActivity {

    private GridView grid;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_grid);
        setSupportActionBar(toolbar);

        grid = (GridView) findViewById(R.id.gallery_grid);
        grid.setAdapter(new Adapter(this));
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
                startActivity(new Intent(GalleryGridActivity.this, MyGalleryActivity.class));
                finish();
                return true;
            case R.id.item_my_gallery:
                startActivity(new Intent(GalleryGridActivity.this, MyGalleryActivity.class));
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

class Category {

    int image;
    String title;

    Category (int image, String title) {
        this.image = image;
        this.title = title;
    }
}

class Adapter extends BaseAdapter {

    ArrayList<Category> list;
    Context context;

    Adapter(Context context) {
        this.context = context;
        this.list = new ArrayList<>();
        String[] categories = context.getResources().getStringArray(R.array.categories);
        int[] images = {
            R.drawable.vintage, R.drawable.sport, R.drawable.portrait,
            R.drawable.people, R.drawable.pattern, R.drawable.nature,
            R.drawable.flower, R.drawable.food, R.drawable.macro,
            R.drawable.abstraction, R.drawable.animal, R.drawable.b_white
        };
        for (int i = 0; i < categories.length; i++) {
            list.add(new Category(images[i], categories[i]));
        }
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Category getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class ViewHolder {

        private ImageView category;
        private TextView title;
        ViewHolder (View view) {
            category = (ImageView) view.findViewById(R.id.category_image_item);
            title = (TextView) view.findViewById(R.id.category_title_item);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        ViewHolder holder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_category_item, parent, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();
        }
        Category temp = list.get(position);
        holder.category.setImageResource(temp.image);
        holder.title.setText(temp.title);
        return row ;
    }
}
