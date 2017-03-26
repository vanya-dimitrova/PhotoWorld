package com.example.user.photoworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.user.photoworld.model.User;

public class ProfileActivity extends AppCompatActivity{

    private MenuItem edit;
    private TextView name;
    private TextView username;
    private TextView address;
    private TextView age;
    private TextView rating;
    private TextView uploads;
    private User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = (TextView) findViewById(R.id.profile_name);
        username = (TextView) findViewById(R.id.profile_username);
        address = (TextView) findViewById(R.id.profile_address);
        age = (TextView) findViewById(R.id.profile_age);
        rating = (TextView) findViewById(R.id.profile_rating);
        uploads = (TextView) findViewById(R.id.profile_uploads);
       // edit = (MenuItem) findViewById(R.id.item_edit);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.getSerializable("user") != null) {
            currentUser = (User) getIntent().getExtras().getSerializable("user");

        }

/*
        ((TextView)findViewById(R.id.name)).setText(user.getUserName());
        ((TextView)findViewById(R.id.username)).setText(user.getUserName());
        ((TextView)findViewById(R.id.email)).setText(user.getUserName()); */
    }
}
