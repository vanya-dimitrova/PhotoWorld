package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.user.photoworld.model.Author;
import com.example.user.photoworld.model.User;

public class ProfileActivity extends AppCompatActivity{

    private static final int SUCCESSFUL_EDIT = 4;

    private TextView name;
    private TextView username;
    private TextView address;
    private TextView age;
    private TextView uploads;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.profile_name);
        username = (TextView) findViewById(R.id.profile_username);
        address = (TextView) findViewById(R.id.profile_address);
        age = (TextView) findViewById(R.id.profile_age);
        uploads = (TextView) findViewById(R.id.profile_uploads);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getSerializable("user") != null) {
            MainActivity.currentUser = (User) getIntent().getExtras().getSerializable("user");
            name.setText(MainActivity.currentUser.getName());
            username.setText(MainActivity.currentUser.getUserName());
            if (MainActivity.currentUser.role.equals(User.Role.AUTHOR)) {
                this.findViewById(R.id.uploads_layout).setVisibility(LinearLayout.VISIBLE);
                uploads.setText(((Author)MainActivity.currentUser).getUploads());
            } else {
                this.findViewById(R.id.uploads_layout).setVisibility(LinearLayout.GONE);
            }
            if (MainActivity.currentUser.getAddress() != null) {
                this.findViewById(R.id.address_layout).setVisibility(LinearLayout.VISIBLE);
                address.setText(MainActivity.currentUser.getAddress());
            } else {
                this.findViewById(R.id.address_layout).setVisibility(LinearLayout.GONE);
            }
            if (MainActivity.currentUser.getAge() != 0) {
                this.findViewById(R.id.age_layout).setVisibility(LinearLayout.VISIBLE);
                age.setText(MainActivity.currentUser.getAge());
            } else {
                this.findViewById(R.id.age_layout).setVisibility(LinearLayout.GONE);
            }
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
                startActivityForResult(new Intent(ProfileActivity.this, EditProfileActivity.class), SUCCESSFUL_EDIT);
            case R.id.item_my_gallery:
                startActivity(new Intent(ProfileActivity.this, MyGalleryActivity.class));
                finish();
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
}
