package com.example.user.photoworld.dialogs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.user.photoworld.R;
import com.example.user.photoworld.login.HomeActivity;

public class LogoutDialogActivity extends AppCompatActivity {

    private TextView logoutMessage;
    private Button logoutButton;
    private Button cancelButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_logout_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        logoutMessage = (TextView) findViewById(R.id.logout_message);
        logoutButton = (Button) findViewById(R.id.logout_dialog_btn);
        cancelButton = (Button) findViewById(R.id.cancel_dialog_btn);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogoutDialogActivity.this, HomeActivity.class));
                finish();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
