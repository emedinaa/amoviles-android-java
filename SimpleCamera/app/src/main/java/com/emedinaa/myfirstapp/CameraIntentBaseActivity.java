package com.emedinaa.myfirstapp;
/**
 * https://developer.android.com/training/permissions/requesting.html
 */

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;

public class CameraIntentBaseActivity extends BaseMediaActivity implements View.OnClickListener{

    private View btnCamera,btnPhoto;
    private ImageView iviPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_intent_base);
        setupMedia();
        app();
    }

    private void app() {
        ui();
    }

    private void ui() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btnCamera= findViewById(R.id.btnCamera);
        btnPhoto= findViewById(R.id.btnPhoto);
        iviPhoto= (ImageView) findViewById(R.id.iviPhoto);

        btnCamera.setOnClickListener(this);
        btnPhoto.setOnClickListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCamera:
                    gotoCamera();
                break;
            case R.id.btnPhoto:
                    gotoPhoto();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case ACTION_GALLERY_PHOTO: {
                if (resultCode == RESULT_OK) {
                    if(data!=null && data.getData()!=null){
                        processPhotoGallery(data.getData());
                    }
                }
                break;
            }

            case ACTION_TAKE_PHOTO: {
                if (resultCode == RESULT_OK) {
                    processPhoto();
                }
                break;
            }
        }
    }

    private void gotoPhoto() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        this.startActivityForResult(galleryIntent, ACTION_GALLERY_PHOTO);
    }

    private void gotoCamera() {
        boolean cameraAvailable= intentHelper.isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE);
        if(!cameraAvailable)return;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        File f = null;
        try {
            f = setUpPhotoFile();
            currentPhotoPath = f.getAbsolutePath();
            //takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, getUri(f));
        } catch (IOException e) {
            e.printStackTrace();
            f = null;
            currentPhotoPath = null;
        }
        startActivityForResult(takePictureIntent, ACTION_TAKE_PHOTO);
    }

    @Override
    protected void renderPhoto() {
        super.renderPhoto();
        Bitmap bitmap= imageHelper.bitmapByPath(iviPhoto.getWidth(),
                iviPhoto.getHeight(),currentPhotoPath);
        /*BitmapFactory.Options bmOptions = new BitmapFactory.Options();

        Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath,bmOptions);
        */
        iviPhoto.setImageBitmap(bitmap);
    }

    private Uri getUri(File file){
        //Uri uri = Uri.fromFile(file);
        Uri uri = FileProvider.getUriForFile(CameraIntentBaseActivity.this, BuildConfig.APPLICATION_ID + ".provider",file);
        return  uri;
    }
}
