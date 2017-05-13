package com.example.user.photoworld.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.user.photoworld.dialogs.LogoutDialogActivity;
import com.example.user.photoworld.dialogs.UploadDialogActivity;
import com.example.user.photoworld.login.HomeActivity;
import com.example.user.photoworld.model.User;
import com.example.user.photoworld.gallery.GalleryActivity;
import com.example.user.photoworld.R;

public class ProfileActivity extends AppCompatActivity {

    private static final int SUCCESSFUL_EDIT = 4;

    private TextView name;
    private TextView username;
    private TextView address;
    private TextView age;
    private TextView email;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        name = (TextView) findViewById(R.id.profile_name);
        username = (TextView) findViewById(R.id.profile_username);
        address = (TextView) findViewById(R.id.profile_address);
        age = (TextView) findViewById(R.id.profile_age);
        email = (TextView) findViewById(R.id.profile_email);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        User user = HomeActivity.gallery.currentUser;

        name.setText(user.getName());
        username.setText(user.getUserName());
        email.setText(user.getEmail());
        if (user.getAddress() != null) {
            address.setText(user.getAddress());
        } else {
            address.setText("------");
        }
        if (user.getAge() != 0) {
            age.setText(user.getAge());
        } else {
            age.setText("------");
        }

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.item_edit:
                Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivityForResult(intent, SUCCESSFUL_EDIT);
                return true;
            case R.id.item_my_gallery:
                startActivity(new Intent(ProfileActivity.this, GalleryActivity.class));
                return true;
            case R.id.item_upload:
                startActivity(new Intent(ProfileActivity.this, UploadDialogActivity.class));
                return true;
            case R.id.item_log_out:
                startActivity(new Intent(ProfileActivity.this, LogoutDialogActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == 1){
            User user = HomeActivity.gallery.currentUser;
            name.setText(user.getName());
            username.setText(user.getUserName());
            address.setText(user.getAddress());
            age.setText(user.getAge() + " ");
            email.setText(user.getEmail());
        }
    }
}

