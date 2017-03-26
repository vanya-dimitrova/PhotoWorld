package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.user.photoworld.model.Author;
import com.example.user.photoworld.model.PhotoWorld;
import com.example.user.photoworld.model.User;

public class RegisterActivity extends AppCompatActivity {

    private EditText name;
    private EditText username;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
<<<<<<< HEAD
    private PhotoWorld gallery;

=======
>>>>>>> 2566fb9dfe8943c75bbc2bbe29bb6721c752b817
    private RadioButton authorRadioButton;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) this.findViewById(R.id.name);
        username = (EditText) this.findViewById(R.id.username);
        email = (EditText) this.findViewById(R.id.email);
        password = (EditText) this.findViewById(R.id.password);
        confirmPassword = (EditText) this.findViewById(R.id.confirm_password);
        authorRadioButton = (RadioButton) this.findViewById(R.id.radio_author);
        registerButton = (Button) this.findViewById(R.id.register_button);
        gallery = PhotoWorld.getPhotoWorld();

        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
<<<<<<< HEAD

                String nameStr = name.getText().toString();
                String usernameStr = username.getText().toString();
                String emailStr = email.getText().toString();
                String passStr = password.getText().toString();
                String confirmPassStr = confirmPassword.getText().toString();

                if(isValidData(nameStr, usernameStr, emailStr, passStr, confirmPassStr)) {
=======
                if(isValidData(MainActivity.gallery)) {
>>>>>>> 2566fb9dfe8943c75bbc2bbe29bb6721c752b817
                    User user;
                    if (authorRadioButton.isChecked()) {
                        user = new Author(name.getText().toString(), username.getText().toString(), email.getText().toString(), password.getText().toString());
                    } else {
                        user = new User(name.getText().toString(), username.getText().toString(), email.getText().toString(), password.getText().toString());
                    }
<<<<<<< HEAD
                    PhotoWorld.getPhotoWorld().register(user);

                    Intent intent = new Intent(RegisterActivity.this, GalleryViewActivity.class);
                    intent.putExtra("user", user);
=======
                    MainActivity.gallery.register(user);

                    // CHECKING PROFILE PAGE
                    //Intent intent = new Intent(RegisterActivity.this, ProfileActivity.class);

                    Intent intent = new Intent(RegisterActivity.this, GalleryActivity.class);
>>>>>>> 2566fb9dfe8943c75bbc2bbe29bb6721c752b817
                    RegisterActivity.this.startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean isValidData(String nameStr, String usernameStr, String emailStr, String passStr, String confirmPassStr) {

        boolean isValid = true;
        if (nameStr.isEmpty()) {
            name.setError(getString(R.string.empty_name));
            isValid = false;
        }
        if (usernameStr.isEmpty()) {
            username.setError(getString(R.string.empty_username));
            isValid = false;
        }
        if (gallery.checkUser(usernameStr)) {
            username.setError(getString(R.string.existing_username));
            isValid = false;
        }
        if (emailStr.isEmpty() || !emailStr.matches("^[_A-Za-z0-9-\\\\+]+(\\\\.[_A-Za-z0-9-]+)*\n" +
                                                    "@[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)*(\\\\.[A-Za-z]{2,})$")) {
            email.setError(getString(R.string.invalid_email));
            isValid = false;
        }
        if (gallery.checkEmail(emailStr)) {
            email.setError(getString(R.string.existing_email));
            isValid = false;
        }
        if (passStr.isEmpty() || !passStr.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
            password.setError(getString(R.string.invalid_password));
            isValid = false;
        }
        if (!passStr.equals(confirmPassStr)) {
            confirmPassword.setError(getString(R.string.password_mismatch));
            isValid = false;
        }
        return isValid;
    }
}
