package com.emedinaa.myfirstapp;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.emedinaa.myfirstapp.helpers.ImageHelper;
import com.emedinaa.myfirstapp.helpers.IntentHelper;
import com.emedinaa.myfirstapp.media.AlbumStorageDirFactory;
import com.emedinaa.myfirstapp.media.BaseAlbumDirFactory;
import com.emedinaa.myfirstapp.media.FroyoAlbumDirFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by emedinaa on 24/02/17.
 */

public abstract class BaseMediaActivity extends AppCompatActivity {

    protected static final int ACTION_TAKE_PHOTO = 1;
    protected static final int ACTION_GALLERY_PHOTO = 2;
    protected static final String JPEG_FILE_PREFIX = "IMG_";
    protected static final String JPEG_FILE_SUFFIX = ".jpg";

    private static final String TAG = "Media";
    private final int REQUEST_WRITE_STORAGE= 100;

    protected AlbumStorageDirFactory albumStorageDirFactory = null;
    protected String currentPhotoPath;
    protected IntentHelper intentHelper;
    protected ImageHelper imageHelper;

    protected void setupMedia(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.FROYO) {
            albumStorageDirFactory = new FroyoAlbumDirFactory();
        } else {
            albumStorageDirFactory = new BaseAlbumDirFactory();
        }
        intentHelper= new IntentHelper();
        imageHelper= new ImageHelper();

        checkPermissions();
    }

    /* check Permission */
    protected void checkPermissions(){
        boolean hasPermission = (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED);

        if (!hasPermission) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    REQUEST_WRITE_STORAGE);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_WRITE_STORAGE: {
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

            // other 'case' lines to check for other
            // permissions this app might request

        }
    }

    /* Photo album for this application */
    private String getAlbumName() {
        return "album_tmp";
    }


    private File getAlbumDir() {
        File storageDir = null;

        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {

            storageDir = albumStorageDirFactory.getAlbumStorageDir(getAlbumName());

            if (storageDir != null) {
                if (! storageDir.mkdirs()) {
                    if (! storageDir.exists()){
                        Log.d(TAG, "failed to create directory");
                        return null;
                    }
                }
            }

        } else {
            Log.v(TAG, "External storage is not mounted READ/WRITE.");
        }

        return storageDir;
    }

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = JPEG_FILE_PREFIX + timeStamp + "_";
        File albumF = getAlbumDir();
        File imageF = File.createTempFile(imageFileName, JPEG_FILE_SUFFIX, albumF);
        return imageF;
    }

    protected File setUpPhotoFile() throws IOException {
        File f = createImageFile();
        currentPhotoPath = f.getAbsolutePath();

        return f;
    }

    protected void processPhoto(){
        if (currentPhotoPath != null) {
            renderPhoto();
            currentPhotoPath = null;
        }
    }

    protected void processPhotoGallery(Uri photoUri){
        currentPhotoPath= pathByUri(photoUri);
        if(currentPhotoPath!=null){
            renderPhoto();
            currentPhotoPath = null;
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

    protected void renderPhoto() {
    }
}
