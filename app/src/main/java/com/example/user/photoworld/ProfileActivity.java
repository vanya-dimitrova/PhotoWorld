package com.example.user.photoworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.photoworld.model.User;

public class ProfileActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        User user = (User) getIntent().getExtras().getSerializable("user");
        ((TextView)findViewById(R.id.name)).setText(user.getUserName());
        ((TextView)findViewById(R.id.username)).setText(user.getUserName());
        ((TextView)findViewById(R.id.email)).setText(user.getUserName());
    }
}
