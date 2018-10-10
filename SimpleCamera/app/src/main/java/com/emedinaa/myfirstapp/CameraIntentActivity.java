package com.emedinaa.myfirstapp;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


import com.emedinaa.myfirstapp.helpers.ImageHelper;
import com.emedinaa.myfirstapp.media.AlbumStorageDirFactory;
import com.emedinaa.myfirstapp.media.BaseAlbumDirFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraIntentActivity extends AppCompatActivity  implements View.OnClickListener{

    private static final String TAG = "CameraIntentA";
    private final int ACTION_TAKE_PHOTO= 100;
    private final int ACTION_GALLERY_PHOTO= 101;
    private final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE=200;
    private final int MY_PERMISSIONS_REQUEST=201;

    private ImageView imageView;

    private AlbumStorageDirFactory mAlbumStorageDirFactory;
    private String mCurrentPhotoPath;
    private boolean enablePermissions=false;
    private ImageHelper imageHelper;

    private void setUpMedia() {
        mAlbumStorageDirFactory = new BaseAlbumDirFactory();
        imageHelper= new ImageHelper();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_intent);
        setUpMedia();
        ui();
        //requestUserPermission();
        checkPermissions();
    }

    private void ui(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imageView= findViewById(R.id.imageView);
        findViewById(R.id.btnCamera).setOnClickListener(this);
        findViewById(R.id.btnGallery).setOnClickListener(this);
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
            case R.id.btnGallery:
                gotoGallery();
                break;
        }
    }

    private Uri getUri(File file){
        //Uri uri = Uri.fromFile(file);
        Uri uri = FileProvider.getUriForFile(CameraIntentActivity.this, BuildConfig.APPLICATION_ID + ".provider",file);
        return  uri;
    }

    private void gotoCamera() {
        if(!enablePermissions) return;
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File f;
        try {
            f = setUpPhotoFile();
            mCurrentPhotoPath = f.getAbsolutePath();
            //takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, getUri(f));
        } catch (IOException e) {
            e.printStackTrace();
            mCurrentPhotoPath = null;
        }
        if(mCurrentPhotoPath!=null){
            startActivityForResult(takePictureIntent, ACTION_TAKE_PHOTO);
        }
    }

    private void gotoGallery() {
        if(!enablePermissions) return;
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        this.startActivityForResult(galleryIntent, ACTION_GALLERY_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case ACTION_TAKE_PHOTO:
                    if(resultCode==RESULT_OK){
                        Log.v(TAG, "take photo "+data);
                        handleBigCameraPhoto();
                    }
                break;
            case ACTION_GALLERY_PHOTO:
                    if(requestCode==RESULT_OK){
                        Log.v(TAG, "gallery photo "+data);
                        if(data!=null && data.getData()!=null){
                            processPhotoGallery(data.getData());
                        }
                    }
                break;
        }
    }

    //media

    protected void renderPhoto() {
        Bitmap bitmap= imageHelper.bitmapByPath(imageView.getWidth(),
                imageView.getHeight(),mCurrentPhotoPath);
        /*BitmapFactory.Options bmOptions = new BitmapFactory.Options();

        Bitmap bitmap= BitmapFactory.decodeFile(currentPhotoPath,bmOptions);
        */
        imageView.setImageBitmap(bitmap);
    }
    protected void processPhotoGallery(Uri photoUri){
        mCurrentPhotoPath= pathByUri(photoUri);
        if(mCurrentPhotoPath!=null){
            renderPhoto();
            mCurrentPhotoPath = null;
        }
    }

    private String pathByUri(Uri uri){
        String path;
        String[] filePathColumn = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, filePathColumn, null, null, null);
        if (cursor == null || cursor.getCount() < 1) {
            path = null;
        }
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
        if(columnIndex < 0) { // no column index
            path = null;
        }
        File file = new File(cursor.getString(columnIndex));
        cursor.close();
        path= file.getAbsolutePath();
        return path;
    }

    private String getAlbumName() {
        return "myAlbum";
    }

    private File setUpPhotoFile() throws IOException {
        File f = createImageFile();
        mCurrentPhotoPath = f.getAbsolutePath();
        return f;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        return File.createTempFile(imageFileName, ".jpg", getAlbumDir());
    }

    private File getAlbumDir() {
        File storageDir = null;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            storageDir = mAlbumStorageDirFactory.getAlbumStorageDir(getAlbumName());
            if (storageDir != null) {
                if (!storageDir.mkdirs()) {
                    if (!storageDir.exists()) {
                        return null;
                    }
                }
            }

        } else {
        }
        return storageDir;
    }

    private void handleBigCameraPhoto() {
        if (mCurrentPhotoPath != null) {
            setPic();
            galleryAddPic();
        }
    }

    private void setPic() {
        /* There isn't enough memory to open up more than a couple camera photos */
        /* So pre-scale the target bitmap into which the file is decoded */

		/* Get the size of the ImageView */
        int targetW = imageView.getWidth();
        int targetH = imageView.getHeight();

		/* Get the size of the image */
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

		/* Figure out which way needs to be reduced less */
        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW / targetW, photoH / targetH);
        }

		/* Set bitmap options to scale the image decode target */
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

		/* Decode the JPEG file into a Bitmap */
        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

        /* Associate the Bitmap to the ImageView */
        imageView.setImageBitmap(bitmap);
    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File f = new File(mCurrentPhotoPath);
        //Uri contentUri = Uri.fromFile(f);
        Uri contentUri = getUri(f);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }

    //runtime permissions
    private void requestUserPermission() {
        if(!isStoragePermissionGranted()){
            //Solicitar nuevamente permission
            enablePermissions=false;
        }else {
            enablePermissions=true;
        }
        Log.d(TAG, "enablePermissions "+enablePermissions);
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            return true;
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
                    MY_PERMISSIONS_REQUEST);
        }else{
            enablePermissions=true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            //case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE: {
            case MY_PERMISSIONS_REQUEST: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    enablePermissions=true;

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    enablePermissions=false;
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

}
