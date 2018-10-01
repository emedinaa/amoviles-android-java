package com.emedinaa.myfirstapp.storage;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.util.Log;

import com.emedinaa.myfirstapp.model.NoteEntity;

import java.util.ArrayList;
import java.util.List;

public class CRUDOperations {

	private NoteDbHelper helper;
	public CRUDOperations(SQLiteOpenHelper _helper) {
		super();
		// TODO Auto-generated constructor stub
		helper =(NoteDbHelper)_helper;
	}

	public  void add(ContentValues values, @NonNull String table) throws Exception{
		SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		db.insert(table, null, values);
		db.close();
	}

	public void addNote(NoteEntity noteEntity)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		 ContentValues values = new ContentValues();
		 values.put(NoteDbHelper.KEY_NAME, noteEntity.getName());
		 values.put(NoteDbHelper.KEY_DESC, noteEntity.getDescription());
		 values.put(NoteDbHelper.KEY_PATH, noteEntity.getPath());
		 
		 db.insert(NoteDbHelper.TABLE_NOTES, null, values);
		 db.close();
	}
	
	public NoteEntity getNote(int id)
	{
		SQLiteDatabase db = helper.getReadableDatabase(); //modo lectura
		Cursor cursor = db.query(NoteDbHelper.TABLE_NOTES,
				new String[]{NoteDbHelper.KEY_ID, NoteDbHelper.KEY_NAME,
						NoteDbHelper.KEY_DESC, NoteDbHelper.KEY_PATH},
				NoteDbHelper.KEY_ID + "=?",
				new String[]{String.valueOf(id)}, null, null, null);
		if(cursor!=null)
		{
			cursor.moveToFirst();
		}
		int nid = Integer.parseInt(cursor.getString(0));
		String name = cursor.getString(1);
		String desc = cursor.getString(2);
		String path = cursor.getString(3);

		NoteEntity noteEntity= new NoteEntity(
				nid, name, desc,path);
		db.close();
		return noteEntity;
	}
	
	public List<NoteEntity> getAllNotes()
	{
		List<NoteEntity> lst =new ArrayList<NoteEntity>();
		String sql= "SELECT  * FROM " + NoteDbHelper.TABLE_NOTES;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		if(cursor.moveToFirst())
		{
			do
			{
				NoteEntity contact =new NoteEntity();
				contact.setId(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setDescription(cursor.getString(2));
				contact.setPath(cursor.getString(3));

				lst.add(contact);
			}while(cursor.moveToNext());
		}
		db.close();
		return lst;
	}
	
	public int getNoteCount()
	{
		String sql= "SELECT * FROM "+ NoteDbHelper.TABLE_NOTES;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		int count=cursor.getCount();
		cursor.close();
		db.close();
		return count;
	}
	
	//--------------------------------------------
	public int updateTable(NoteEntity noteEntity,ContentValues values,
						   @NonNull  String table) throws Exception{
		SQLiteDatabase db = helper.getWritableDatabase();
		return 0;
	}

	public int updateNote(NoteEntity noteEntity) {
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(NoteDbHelper.KEY_NAME, noteEntity.getName());
		values.put(NoteDbHelper.KEY_DESC, noteEntity.getDescription());
		values.put(NoteDbHelper.KEY_PATH, noteEntity.getPath());

		int row =db.update(NoteDbHelper.TABLE_NOTES,
				values,
				NoteDbHelper.KEY_ID+"=?",
				new String[]{String.valueOf(noteEntity.getId())});
		db.close();

		return row;
	}

	//--------------------------------------------
	public int deleteNote(NoteEntity noteEntity)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); 
		 int row= db.delete(NoteDbHelper.TABLE_NOTES,
				 NoteDbHelper.KEY_ID+"=?",
				 new String[]{String.valueOf(noteEntity.getId())});
		 db.close();
		return row;
	}

	public long getNoteCountWithStatement(){
		String sql= "select count(*) from "+ NoteDbHelper.TABLE_NOTES;
		SQLiteDatabase db = helper.getReadableDatabase();
		SQLiteStatement s = db.compileStatement(sql);
		long count = s.simpleQueryForLong();
		db.close();

		return count;
	}

	private void clearTable(String table){
		String clearDBQuery = "DELETE FROM "+table;
		SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		db.execSQL(clearDBQuery);
		db.close();
	}

	public void clearDb(){
		clearTable(NoteDbHelper.TABLE_NOTES);
		//clearTable(MyDatabase.TABLE_USER);
	}

	//Content provider
	public void insert(@NonNull final Context context,NoteEntity noteEntity){
		ContentValues contentValues = new ContentValues();
		contentValues.put(NoteContract.NoteEntry.COLUMN_NAME, noteEntity.getName());
		contentValues.put(NoteContract.NoteEntry.COLUMN_DESC, noteEntity.getDescription());
		contentValues.put(NoteContract.NoteEntry.COLUMN_PATH, noteEntity.getPath());

		Uri uri= NoteContract.NoteEntry.CONTENT_URI;
		Uri uriRowInserted=context.getContentResolver().insert(uri,contentValues);

		Log.i("CRUD","Item inserted ar "+uriRowInserted);
	}

	public List<NoteEntity> getAllNotes(@NonNull final Context context)
	{
		List<NoteEntity> lst =new ArrayList<NoteEntity>();
		Uri uri= NoteContract.NoteEntry.CONTENT_URI;
		String[] projection= {
				NoteContract.NoteEntry.ID, NoteContract.NoteEntry.COLUMN_NAME,
				NoteContract.NoteEntry.COLUMN_DESC,
				NoteContract.NoteEntry.COLUMN_PATH};

		String selection=null;
		String[] selectionArg=null;
		String sortOrden= null;
		Cursor cursor =context.getContentResolver().query(uri,projection,selection,
				selectionArg,sortOrden);

		if(cursor!=null && cursor.moveToFirst())
		{
			do
			{
				NoteEntity contact =new NoteEntity();
				contact.setId(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setDescription(cursor.getString(2));
				contact.setPath(cursor.getString(3));

				lst.add(contact);
			}while(cursor.moveToNext());
			cursor.close();
		}
		return lst;
	}

	public NoteEntity getNote(@NonNull final Context context,String rowId){
		String[] projection= {
				NoteContract.NoteEntry.ID, NoteContract.NoteEntry.COLUMN_NAME,
				NoteContract.NoteEntry.COLUMN_DESC,
				NoteContract.NoteEntry.COLUMN_PATH};

		String selection= NoteContract.NoteEntry.ID;
		String[] selectionArgs={rowId};
		String sortOrden= null;

		Uri uri= Uri.withAppendedPath(NoteContract.NoteEntry.CONTENT_URI,rowId);
		Cursor cursor= context.getContentResolver().query(uri,projection,
				selection,selectionArgs,sortOrden);

		NoteEntity noteEntity=null;
		if (cursor != null && cursor.moveToNext()) {
			int nid = Integer.parseInt(cursor.getString(0));
			String name = cursor.getString(1);
			String desc = cursor.getString(2);
			String path = cursor.getString(3);

			noteEntity= new NoteEntity(
					nid, name, desc,path);
		}
		return noteEntity;
	}

	public int updateNote(@NonNull final Context context,NoteEntity noteEntity) {

		String selection = NoteContract.NoteEntry.ID + " = ?";
		String[] selectionArgs = { String.valueOf(noteEntity.getId()) };			// WHERE country = ? = Japan

		ContentValues contentValues = new ContentValues();
		contentValues.put(NoteDbHelper.KEY_NAME, noteEntity.getName());
		contentValues.put(NoteDbHelper.KEY_DESC, noteEntity.getDescription());
		contentValues.put(NoteDbHelper.KEY_PATH, noteEntity.getPath());

		Uri uri= NoteContract.NoteEntry.CONTENT_URI;
		int rowsUpdated= context.getContentResolver().update(uri,contentValues,selection,selectionArgs);
		return rowsUpdated;
	}

	public int deleteNote(@NonNull final Context context,NoteEntity noteEntity)
	{
		String selection = NoteContract.NoteEntry.ID + " = ?";
		String[] selectionArgs = { String.valueOf(noteEntity.getId()) };

		int rowId= noteEntity.getId();
		String rowName= noteEntity.getName();

		//Uri uri = Uri.withAppendedPath(NoteContract.NoteEntry.CONTENT_URI, rowId);
		//Uri uri = Uri.withAppendedPath(NoteContract.NoteEntry.CONTENT_URI, rowId);
		Uri uri = ContentUris.withAppendedId(NoteContract.NoteEntry.CONTENT_URI,rowId);
		int rowDeleted = context.getContentResolver().delete(uri, selection, selectionArgs);
		return rowDeleted;
	}
}
