package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;

    private Button registerButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) this.findViewById(R.id.name);
        username = (EditText) this.findViewById(R.id.username);
        email = (EditText) this.findViewById(R.id.email);
        password = (EditText) this.findViewById(R.id.password);
        confirmPassword = (EditText) this.findViewById(R.id.confirm_password);

        registerButton = (Button) this.findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValidData()) {
                    //add user
                    Intent intent = new Intent(RegisterActivity.this, GalleryView.class);
                    RegisterActivity.this.startActivity(intent);
                }
            }
        });
    }

    private boolean isValidData() {
        boolean isValid = true;
        String nameStr = name.getText().toString();
        String usernameStr = username.getText().toString();
        String emailStr = email.getText().toString();
        String passStr = password.getText().toString();
        String confirmPassStr = confirmPassword.getText().toString();

        if (nameStr.isEmpty()) {
            name.setError("Name must not be empty!");
            isValid = false;
        }
        if (usernameStr.isEmpty()) {
            username.setError("Username must not be empty!");
            isValid = false;
        }
        if (emailStr.isEmpty()) {
            email.setError("Email is not valid!");
            isValid = false;
        }
        if (passStr.isEmpty() || passStr.length() < 5) {
            password.setError("The password is too short!");
            isValid = false;
        }
        if (!passStr.equals(confirmPassStr)) {
            confirmPassword.setError("Passwords do not match!");
            isValid = false;
        }
        return isValid;
    }
}
