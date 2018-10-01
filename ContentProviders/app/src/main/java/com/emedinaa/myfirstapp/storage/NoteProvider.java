package com.emedinaa.myfirstapp.storage;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/30/18
 *
 * Content URIs
 * content://<authority>/path_name  (package name / class name)
 * content://<package_name>.contentprovider/path_name
 * content://com.emedinaa.myfirstapp.NoteProvider/tb_notes (table / file)
 *
 * samples :
 * content://com.myapp.provider/table1
 * content://com.myapp.provider/table1/#
 * content://com.myapp.provider/table1/*
 */
public class NoteProvider extends ContentProvider {
    private final String TAG="NPROVIDER";
    private NoteDbHelper noteDbHelper;

    private static final UriMatcher uriMatcher= new UriMatcher(UriMatcher.NO_MATCH);

    //constants for the operation
    private static final int NOTES=1;
    private static final int NOTES_ID=2;
    private static final int NOTES_NOTE_NAME=3;

    static{
        uriMatcher.addURI(NoteContract.CONTENT_AUTHORITY,NoteContract.PATH_NOTES,NOTES);//1);
        uriMatcher.addURI(NoteContract.CONTENT_AUTHORITY,NoteContract.PATH_NOTES+"/#",NOTES_ID);//3);
        uriMatcher.addURI(NoteContract.CONTENT_AUTHORITY,NoteContract.PATH_NOTES+"/*",NOTES_NOTE_NAME);//2);
    }

    @Override
    public boolean onCreate() {
        noteDbHelper= new NoteDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database= noteDbHelper.getReadableDatabase();
        Cursor cursor;
        switch (uriMatcher.match(uri)){
            case NOTES:
                cursor= database.query(NoteContract.NoteEntry.TABLE_NAME,projection,
                        selection,selectionArgs,null,null,sortOrder);
                break;
            case NOTES_ID:
                cursor= database.query(NoteContract.NoteEntry.TABLE_NAME,projection,
                        selection,selectionArgs,null,null,sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Error uri "+uri);
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        switch (uriMatcher.match(uri)){
            case NOTES:
                return insertRecord(uri,values,NoteContract.NoteEntry.TABLE_NAME);
            default:
                throw new IllegalArgumentException("Error uri "+uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch (uriMatcher.match(uri)){
            case NOTES_ID:		// To delete a row by ID
                selection = NoteContract.NoteEntry.ID + " = ?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return deleteRecord(selection, selectionArgs, NoteContract.NoteEntry.TABLE_NAME);
             default:
                 throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        switch (uriMatcher.match(uri)) {
            case NOTES:// For Notes Table
                return updateRecord(values, selection, selectionArgs, NoteContract.NoteEntry.TABLE_NAME);
            default:
                throw new IllegalArgumentException(TAG + "Unknown URI: " + uri);
        }
    }

    private Uri insertRecord(Uri uri,ContentValues values,String tableName){
        SQLiteDatabase database= noteDbHelper.getWritableDatabase();
        long rowId= database.insert(NoteContract.NoteEntry.TABLE_NAME,null,values);
        if(rowId<0){
            Log.v(TAG,"Insert error for Uri "+uri);
            return null;
        }
        return ContentUris.withAppendedId(uri,rowId);
    }

    private int updateRecord(ContentValues values, String selection, String[] selectionArgs, String tableName) {
        SQLiteDatabase database = noteDbHelper.getWritableDatabase();
        int rowsUpdated = database.update(tableName, values, selection, selectionArgs);
        return rowsUpdated;
    }

    private int deleteRecord(String selection, String[] selectionArgs, String tableName) {
        SQLiteDatabase database = noteDbHelper.getWritableDatabase();
        int rowsDeleted = database.delete(tableName, selection, selectionArgs);
        return rowsDeleted;
    }
}
