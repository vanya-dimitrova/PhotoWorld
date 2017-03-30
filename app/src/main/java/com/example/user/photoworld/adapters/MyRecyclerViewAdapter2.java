package com.example.user.photoworld.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.user.photoworld.model.Photo;
import com.example.user.photoworld.photoGallery.PhotoViewActivity;
import com.example.user.photoworld.R;

import java.util.List;

/**
 * Created by Maria on 29.3.2017 г..
 */

public class MyRecyclerViewAdapter2 extends RecyclerView.Adapter<MyRecyclerViewAdapter2.MyViewHolder2> {

    private List<Photo> categoryPhotos;
    private final Context context;

    public MyRecyclerViewAdapter2(Context context, List<Photo> categoryPhotos){
        this.categoryPhotos = categoryPhotos;
        this.context = context;
    }

    class MyViewHolder2 extends RecyclerView.ViewHolder{
        View row;
        ImageView image;

        MyViewHolder2(View row) {
            super(row);
            this.row = row;
            image = (ImageView) this.row.findViewById(R.id.category_single_image);
        }
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View row = li.inflate(R.layout.single_category_image, parent, false);
        MyViewHolder2 vh = new MyViewHolder2(row);
        return vh;
    }


    @Override
    public void onBindViewHolder(final MyViewHolder2 holder, int position) {
        final Photo photo = categoryPhotos.get(position);
        holder.image.setImageResource(photo.getPhotoId());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("gr", "vliza v metoda");
                Intent i = new Intent(context, PhotoViewActivity.class);
                i.putExtra("photo", photo);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryPhotos.size();
    }

}
