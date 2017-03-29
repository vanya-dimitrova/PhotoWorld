package com.example.user.photoworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.user.photoworld.model.User;

import static com.example.user.photoworld.MainActivity.currentUser;

public class EditProfileActivity extends AppCompatActivity {

    private EditText name;
    private EditText address;
    private EditText age;
    private EditText oldPass;
    private EditText newPass;
    private EditText confirmPass;
    private Button cancel;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        name = (EditText) findViewById(R.id.edit_name);
        address = (EditText) findViewById(R.id.edit_address);
        age = (EditText) findViewById(R.id.edit_age);
        oldPass = (EditText) findViewById(R.id.edit_old_pass);
        newPass = (EditText) findViewById(R.id.edit_new_pass);
        confirmPass = (EditText) findViewById(R.id.edit_confirm_pass);
        cancel = (Button) findViewById(R.id.cancel_btn);
        save = (Button) findViewById(R.id.save_btn);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null && bundle.getSerializable("user") != null){
            currentUser = (User) bundle.getSerializable("user");
            this.name.setText(currentUser.getName());
            if (address != null) {
              this.address.setText(currentUser.getAddress());
            }
            if (age != null) {
                this.age.setText(currentUser.getAge());
            }
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameStr = name.getText().toString();
                String ageStr = age.getText().toString();
                String addressStr = address.getText().toString();
                String oldPassStr = oldPass.getText().toString();
                String newPassStr = newPass.getText().toString();
                String newPass2Str = confirmPass.getText().toString();

                if(isValidData(nameStr, ageStr, addressStr, oldPassStr, newPassStr, newPass2Str)){
                    currentUser.setName(nameStr);
                    currentUser.setAge(Integer.parseInt(ageStr));
                    currentUser.setAddress(addressStr);
                    currentUser.setPassword(newPass2Str);
                }
                Intent returnIntent = getIntent();
                returnIntent.putExtra("user", currentUser);
                setResult(EditProfileActivity.RESULT_OK, returnIntent);
                finish();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                finish();
            }
        });
    }

    private boolean isValidData(String nameStr, String ageStr, String addressStr, String oldPassStr, String newPassStr, String newPass2Str) {
        boolean isValid = true;
        int ageInt = Integer.parseInt(ageStr);

        if (nameStr.isEmpty() || nameStr.length() < 2) {
            name.setError(getString(R.string.empty_name));
            isValid = false;
        }
        if (!ageStr.isEmpty() && (ageInt < 1 || ageInt > 120)) {
            age.setError(getString(R.string.invalid_age));
            isValid = false;
        }

        if (!addressStr.isEmpty() && addressStr.length() < 5) {
            address.setError(getString(R.string.invalid_address));
            isValid = false;
        }

        if (!oldPassStr.isEmpty() && !newPassStr.isEmpty() && !newPass2Str.isEmpty()) {
            if (!currentUser.getPassword().equals(oldPassStr)) {
                oldPass.setError(getString(R.string.password_mismatch));
                isValid = false;
            }
            if (!newPassStr.equals(newPass2Str)) {
                confirmPass.setError(getString(R.string.password_mismatch));
                isValid = false;
            }
        }
        return isValid;
    }
}
