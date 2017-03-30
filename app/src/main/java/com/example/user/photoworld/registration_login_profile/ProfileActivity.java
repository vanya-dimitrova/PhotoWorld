package com.example.user.photoworld.registration_login_profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.photoworld.photoGallery.MyGalleryActivity;
import com.example.user.photoworld.R;
import com.example.user.photoworld.model.User;

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


        name.setText(MainActivity.currentUser.getName());
        username.setText(MainActivity.currentUser.getUserName());
        email.setText(MainActivity.currentUser.getEmail());
        if (MainActivity.currentUser.getAddress() != null) {
            address.setText(MainActivity.currentUser.getAddress());
        } else {
            address.setText("------");
        }
        if (MainActivity.currentUser.getAge() != 0) {
            age.setText(MainActivity.currentUser.getAge());
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
                startActivity(new Intent(ProfileActivity.this, MyGalleryActivity.class));
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
        Toast.makeText(this, "onactivityresult", Toast.LENGTH_SHORT).show();
        if(resultCode == 1){
            Toast.makeText(this, "v ifaaaaaaaaaaaa", Toast.LENGTH_SHORT).show();

            name.setText(MainActivity.currentUser.getName());
            username.setText(MainActivity.currentUser.getUserName());
            address.setText(MainActivity.currentUser.getAddress());
            age.setText(MainActivity.currentUser.getAge() + " ");
            email.setText(MainActivity.currentUser.getEmail());
        }
    }
}
