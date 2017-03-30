package com.example.user.photoworld.registration_login_profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.photoworld.R;
import com.example.user.photoworld.model.Author;

public class UploadDialogActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMG = 2;
    private static final int RESULT_LOAD_IMAGE = 1;
    private static final int RESULT_NOT_LOADED = 6;

    private TextView fileName;
    private ImageButton folderIcon;
    private Button uploadButton;
    private Button cancelButton;
    private String imageStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_dialog);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setTitle("Upload file");

        folderIcon = (ImageButton) findViewById(R.id.upload_icon);
        fileName = (TextView) findViewById(R.id.upload_file_name);
        cancelButton = (Button) findViewById(R.id.cancel_upload_btn);
        uploadButton = (Button) findViewById(R.id.upload_dialog_btn);

        folderIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });
        /*
        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Author author = (Author) MainActivity.currentUser;
        String category = author.offerPhoto().getCategory();
        if(! MainActivity.gallery.updatePhotos(author.getUserName(), category)){
            Toast.makeText(this, "Picture already exists", Toast.LENGTH_SHORT).show();
        }

            }
        });
        */

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    //TODO
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



    }
}
