package com.example.user.photoworld.gallery;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.photoworld.R;
import com.example.user.photoworld.model.Photo;
import com.example.user.photoworld.category.CategoryActivity;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.MyViewHolder> {

   private List<CategoryHelp> categoryArrayList;
    private Context context;

   public GalleryAdapter(Context context, List<CategoryHelp> categoryArrayList){
        this.categoryArrayList = categoryArrayList;
        this.context = context;
   }

    class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text;

        MyViewHolder(View row) {
            super(row);
            image = (ImageView) row.findViewById(R.id.category_image_item);
            text = (TextView) row.findViewById(R.id.category_title_item);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View row = li.inflate(R.layout.single_category_item, parent, false);
        MyViewHolder vh = new MyViewHolder(row);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        CategoryHelp categoryHelp = categoryArrayList.get(position);
        holder.image.setImageResource(categoryHelp.image);
        holder.text.setText(categoryHelp.title);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, CategoryActivity.class);
                switch (holder.text.getText().toString()) {
                    case "Abstraction":
                        i.putExtra("category", Photo.Category.ABSTRACT);
                        context.startActivity(i);
                        break;
                    case "Animal":
                        i.putExtra("category", Photo.Category.ANIMAL);
                        context.startActivity(i);
                        break;
                    case "Black&White":
                        i.putExtra("category", Photo.Category.BLACK_AND_WHITE);
                        context.startActivity(i);
                        break;
                    case "Flower":
                        i.putExtra("category", Photo.Category.FLOWER);
                        context.startActivity(i);
                        break;
                    case "Food":
                        i.putExtra("category", Photo.Category.FOOD);
                        context.startActivity(i);
                        break;
                    case "Macro":
                        i.putExtra("category", Photo.Category.MACRO);
                        context.startActivity(i);
                        break;
                    case "Nature":
                        i.putExtra("category", Photo.Category.NATURE);
                        context.startActivity(i);
                        break;
                    case "Pattern":
                        i.putExtra("category", Photo.Category.PATTERN);
                        context.startActivity(i);
                        break;
                    case "People":
                        i.putExtra("category", Photo.Category.PEOPLE);
                        context.startActivity(i);
                        break;
                    case "Portrait":
                        i.putExtra("category", Photo.Category.PORTRAIT);
                        context.startActivity(i);
                        break;
                    case "Sport":
                        i.putExtra("category", Photo.Category.SPORT);
                        context.startActivity(i);
                        break;
                    case "Vintage":
                        i.putExtra("category", Photo.Category.VINTAGE);
                        context.startActivity(i);
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryArrayList.size();
    }

    public static class CategoryHelp {

        int image;
        String title;

        public CategoryHelp (int image, String title) {
            this.image = image;
            this.title = title;
        }
    }
}
