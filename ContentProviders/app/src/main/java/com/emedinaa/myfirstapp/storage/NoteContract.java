package com.emedinaa.myfirstapp.storage;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/30/18
 */
public class NoteContract {

    public static final String CONTENT_AUTHORITY="com.emedinaa.myfirstapp.storage.NoteProvider";//"<packageName>.myContentProvider";
    //BASE_CONTENT_URI : content://com.emedinaa.myfirstapp.storage.NoteProvider
    public static final Uri BASE_CONTENT_URI=Uri.parse("content://"+CONTENT_AUTHORITY);

    //Path to get CLIENT APP to our table
    public static final String PATH_NOTES= "tb_notes";

    public static final class NoteEntry implements BaseColumns{

        public static final  Uri CONTENT_URI= Uri.withAppendedPath(BASE_CONTENT_URI,PATH_NOTES);

        //Table Name
        public static String TABLE_NAME="tb_notes";

        //Columns
        public static final String ID="id";//BaseColumns._ID;
        public static final String COLUMN_NAME="name";
        public static final String COLUMN_DESC="desc";
        public static final String COLUMN_PATH="path";
    }
}
