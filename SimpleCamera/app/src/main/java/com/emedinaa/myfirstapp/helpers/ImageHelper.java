package com.emedinaa.myfirstapp.helpers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;

import java.io.IOException;

/**
 * Created by emedinaa on 24/02/17.
 */

public class ImageHelper {

    public Bitmap bitmapByPath(int imageWidth,int imageHeight,String path){
        /* There isn't enough memory to open up more than a couple camera photos */
		/* So pre-scale the target bitmap into which the file is decoded */

		/* Get the size of the ImageView */
        int targetW = imageWidth;
        int targetH = imageHeight;

		/* Get the size of the image */
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(path, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

		/* Figure out which way needs to be reduced less */
        int scaleFactor = 1;
        if ((targetW > 0) || (targetH > 0)) {
            scaleFactor = Math.min(photoW/targetW, photoH/targetH);
        }

		/* Set bitmap options to scale the image decode target */
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        bmOptions.inPurgeable = true;

		/* Decode the JPEG file into a Bitmap */
        Bitmap originalBitmap = BitmapFactory.decodeFile(path, bmOptions);
        Bitmap bitmap= fixOrientationBitmap(path,originalBitmap);
        if(originalBitmap.isRecycled()){
            originalBitmap.recycle();
            originalBitmap=null;
        }
        return bitmap;
    }

    private Bitmap fixOrientationBitmap(String path, Bitmap bitmap){
        Matrix matrix= new Matrix();
        matrix.postRotate(angleByPath(path));

        Bitmap mBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
        return  mBitmap;
    }

    private int angleByPath(String path){
        ExifInterface exif = null;
        try {
            exif = new ExifInterface(path);
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        String tagOrientation = exif.getAttribute(ExifInterface.TAG_ORIENTATION);
        int orientation = tagOrientation != null ? Integer.parseInt(tagOrientation) :  ExifInterface.ORIENTATION_NORMAL;

        int degree = 0;
        switch (orientation){

            case ExifInterface.ORIENTATION_FLIP_HORIZONTAL:
                degree=0; //scale -1, 1
                break;
            case ExifInterface.ORIENTATION_FLIP_VERTICAL:
                degree=180; //scale -1, 1
                break;
            case ExifInterface.ORIENTATION_TRANSPOSE:
                degree=90; //scale -1, 1
                break;
            case ExifInterface.ORIENTATION_TRANSVERSE:
                degree=90; //-1,1
                break;
            case ExifInterface.ORIENTATION_NORMAL:
                degree=0;
                break;
            case ExifInterface.ORIENTATION_ROTATE_90:
                degree= 90;
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                degree=180;
                break;
            case ExifInterface.ORIENTATION_ROTATE_270:
                degree=270; //-90
                break;
        }
        return degree;
    }
}
