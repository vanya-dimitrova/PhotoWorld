package com.example.user.photoworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class UploadDialogActivity extends AppCompatActivity {

    private static final int RESULT_LOAD_IMG = 2;

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
        cancelButton = (Button) findViewById(R.id.cancel_dialog_btn);
        uploadButton = (Button) findViewById(R.id.upload_dialog_btn);

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
               // startActivityForResult(intent, RESULT_LOAD_IMG);
               // finish();
                //OVERRIDE ON ACTIVITY RESULT
            }
        });

        /*cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
    }
}
