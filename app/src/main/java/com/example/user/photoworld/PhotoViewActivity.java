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

import com.example.user.photoworld.model.Photo;
import com.example.user.photoworld.model.User;

public class PhotoViewActivity extends AppCompatActivity {

    private static final int PICK_IMAGE_REQUEST = 5;

    private Toolbar toolbar;
    private MenuItem itemSave;
    private MenuItem itemShare;
    private MenuItem itemSetAs;
    private MenuItem itemUpload;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo);


        image = (ImageView) findViewById(R.id.image_view);
        //image.setImageResource(photoToGet.photoId);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        itemSave = (MenuItem) findViewById(R.id.item_save);
        itemShare = (MenuItem) findViewById(R.id.item_share);
        itemSetAs = (MenuItem) findViewById(R.id.item_set_as);
        itemUpload = (MenuItem) findViewById(R.id.item_upload);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getSerializable("photo") != null && bundle.getSerializable("user") != null) {
            Photo photoToGet = (Photo) bundle.getSerializable("photo");
            MainActivity.currentUser = (User) bundle.getSerializable("user");
            if (MainActivity.currentUser.getRole().equals(User.Role.USER)) {
                itemUpload.setVisible(false);
            }
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_photo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.item_profile:startActivity(new Intent(PhotoViewActivity.this, ProfileActivity .class));
                finish();
                return true;
            case R.id.item_my_gallery:
                startActivity(new Intent(PhotoViewActivity.this, MyGalleryActivity.class));
                finish();
                return true;
            case R.id.item_upload:
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select image"), PICK_IMAGE_REQUEST);
               // startActivity(new Intent(PhotoViewActivity.this, UploadDialogActivity.class));
                return true;
            case R.id.item_log_out:
                startActivity(new Intent(PhotoViewActivity.this, LogoutDialogActivity.class));
                return true;
            case R.id.item_save:
                saveImageFile();
                return true;
            case R.id.item_share:
                shareImage();
                return true;
            case R.id.item_set_as:
                setImageAs();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void saveImageFile() {

       /* image.setDrawingCacheEnabled(true);
        Bitmap b = image.getDrawingCache();
        MediaStore.Images.Media.insertImage(getActivity().getContentResolver(), b,title, description);*/
    }

    private void shareImage() {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("image/*");
        // not sure if correct
        String uri = "android.resource://" + getPackageName() + getResources().getResourceEntryName(R.id.image_view);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    private void setImageAs() {
        /*
        image.setImageResource(R.id.image_view);
        WallpaperManager myWallpaperManager = WallpaperManager.getInstance(getApplicationContext());
        try {
            myWallpaperManager.setResource(R.id.image_view);
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
