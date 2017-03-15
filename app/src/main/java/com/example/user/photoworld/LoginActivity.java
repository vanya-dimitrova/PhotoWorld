package com.example.user.photoworld;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.photoworld.model.User;

import java.util.HashSet;

public class LoginActivity extends AppCompatActivity {

    private HashSet<User> users;
    private EditText username;
    private EditText password;
    private Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) this.findViewById(R.id.login_username);
        password = (EditText) this.findViewById(R.id.login_password);

        loginButton = (Button) this.findViewById(R.id.login_button);
    }
}
