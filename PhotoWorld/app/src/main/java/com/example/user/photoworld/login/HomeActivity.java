package com.example.user.photoworld.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.user.photoworld.R;
import com.example.user.photoworld.model.PhotoWorld;

public class HomeActivity extends AppCompatActivity {

    private Button signUp;
    private Button login;

    public static PhotoWorld gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = PhotoWorld.getPhotoWorld();

        Button signUp = (Button) findViewById(R.id.sign_up);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, RegisterActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });

        Button login = (Button) findViewById(R.id.log_in);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });
    }
}
