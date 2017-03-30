package com.example.user.photoworld.registration_login_profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.user.photoworld.photoGallery.MyGalleryActivity;
import com.example.user.photoworld.R;
import com.example.user.photoworld.model.Author;
import com.example.user.photoworld.model.User;

import static com.example.user.photoworld.registration_login_profile.MainActivity.gallery;

public class RegisterActivity extends AppCompatActivity {

    private EditText nameText;
    private EditText usernameText;
    private EditText emailText;
    private EditText passwordText;
    private EditText confirmPasswordText;
    private RadioButton authorRadioButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameText = (EditText) this.findViewById(R.id.name);
        usernameText = (EditText) this.findViewById(R.id.username);
        emailText = (EditText) this.findViewById(R.id.email);
        passwordText = (EditText) this.findViewById(R.id.password);
        confirmPasswordText = (EditText) this.findViewById(R.id.confirm_password);
        authorRadioButton = (RadioButton) this.findViewById(R.id.radio_author);
        registerButton = (Button) this.findViewById(R.id.register_button);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameStr = nameText.getText().toString();
                String usernameStr = usernameText.getText().toString();
                String emailStr = emailText.getText().toString();
                String passStr = passwordText.getText().toString();
                String confirmPassStr = confirmPasswordText.getText().toString();

                if(isValidData(nameStr, usernameStr, emailStr, passStr, confirmPassStr)) {
                    User user;
                    if (authorRadioButton.isChecked()) {
                        user = new Author(nameStr, usernameStr, emailStr, passStr, User.Role.AUTHOR);
                    } else {
                        user = new User(nameStr, usernameStr, emailStr, passStr, User.Role.USER);
                    }
                    MainActivity.gallery.register(user);
                    Intent intent = new Intent(RegisterActivity.this, MyGalleryActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean isValidData(String nameStr, String usernameStr, String emailStr, String passStr, String confirmPassStr) {

        boolean isValid = true;
        if (nameStr.isEmpty()) {
            nameText.setError(getString(R.string.empty_name));
            isValid = false;
        }
        if (usernameStr.isEmpty()) {
            usernameText.setError(getString(R.string.empty_username));
            isValid = false;
        }
        if (gallery.checkUser(usernameStr)) {
            usernameText.setError(getString(R.string.existing_username));
            isValid = false;
        }
        if (emailStr.isEmpty() || !emailStr.matches("^(.+)@(.+)$")) {
            emailText.setError(getString(R.string.invalid_email));
            isValid = false;
        }
        if (gallery.checkEmail(emailStr)) {
            emailText.setError(getString(R.string.existing_email));
            isValid = false;
        }
        if (passStr.isEmpty() || !passStr.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            passwordText.setError(getString(R.string.invalid_password));
            isValid = false;
        }
        if (!passStr.equals(confirmPassStr)) {
            confirmPasswordText.setError(getString(R.string.password_mismatch));
            isValid = false;
        }
        return isValid;
    }
}
