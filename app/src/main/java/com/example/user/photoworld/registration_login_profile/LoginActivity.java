package com.example.user.photoworld.registration_login_profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.photoworld.photoGallery.MyGalleryActivity;
import com.example.user.photoworld.R;
import com.example.user.photoworld.model.PhotoWorld;
import com.example.user.photoworld.model.User;

import java.util.HashSet;

import static com.example.user.photoworld.registration_login_profile.MainActivity.gallery;

public class LoginActivity extends AppCompatActivity {

    private HashSet<User> users;
    private EditText username;
    private EditText password;
    private Button loginButton;
    private TextView registerHere;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) this.findViewById(R.id.login_username);
        password = (EditText) this.findViewById(R.id.login_password);

        registerHere = (TextView) this.findViewById(R.id.register_here);
        registerHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
                finish();
            }
        });

        loginButton = (Button) this.findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isValidData(gallery)) {
                    gallery.login(username.getText().toString());
                    Intent intent = new Intent(LoginActivity.this, MyGalleryActivity.class);
                    LoginActivity.this.startActivity(intent);
                    MainActivity.currentUser = MainActivity.gallery.users.get(username.getText().toString());
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Wrong username or password!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidData(PhotoWorld gallery) {
        boolean isValid = true;
        String usernameStr = username.getText().toString();
        String passStr = password.getText().toString();

        if (!gallery.checkUser(usernameStr)) {
           // username.setError(getString(R.string.wrong_username));
            isValid = false;
        }
        if (!gallery.checkPassword(usernameStr, passStr)) {
           // password.setError(getString(R.string.wrong_password));
            isValid = false;
        }
        return isValid;
    }
}