package com.emedinaa.myfirstapp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.emedinaa.myfirstapp.helpers.ImageHelper;
import com.emedinaa.myfirstapp.media.CameraActivity;


public class CustomCameraActivity extends AppCompatActivity {

    private final int REQUEST_CAMERA=1;
    private final int REQUEST_PERMISSION=100;

    private ImageView iviPhoto;
    protected String currentPhotoPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_camera);
        checkPermissions();
        ui();
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }
        }
    }

    private void checkPermissions() {
        boolean storagePermission = (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);

        boolean cameraPermission= (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED);

        if (!storagePermission || !cameraPermission) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.CAMERA},
                    REQUEST_PERMISSION);
        }
    }

    private void ui() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        iviPhoto= findViewById(R.id.iviPhoto);
        iviPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoCamera();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode== REQUEST_CAMERA){
            if(resultCode==Activity.RESULT_OK){
                if(data==null)return;
                Bundle bundle= data.getExtras();
                if(bundle!=null){
                    currentPhotoPath= bundle.getString("PATH");
                    renderPhoto();
                }

            }
        }
    }

    private void renderPhoto() {
        Bitmap bitmap= new ImageHelper().bitmapByPath(iviPhoto.getWidth(),
                iviPhoto.getHeight(),currentPhotoPath);
        iviPhoto.setImageBitmap(bitmap);
    }

    private void gotoCamera() {
        startActivityForResult(new Intent(this,CameraActivity.class),REQUEST_CAMERA);
    }
}
