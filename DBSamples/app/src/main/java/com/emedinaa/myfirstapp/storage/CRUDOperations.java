package com.emedinaa.myfirstapp.storage;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.emedinaa.myfirstapp.model.NoteEntity;

import java.util.ArrayList;
import java.util.List;

public class CRUDOperations {

	private MyDatabase helper;
	public CRUDOperations(SQLiteOpenHelper _helper) {
		super();
		// TODO Auto-generated constructor stub
		helper =(MyDatabase)_helper;
	}

	public void addNote(NoteEntity noteEntity)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
		 ContentValues values = new ContentValues();
		 values.put(MyDatabase.KEY_NAME, noteEntity.getName());
		 values.put(MyDatabase.KEY_DESC, noteEntity.getDescription());
		 values.put(MyDatabase.KEY_PATH, noteEntity.getPath());
		 
		 db.insert(MyDatabase.TABLE_NOTES, null, values);
		 db.close();
	}
	
	public NoteEntity getNote(int id)
	{
		SQLiteDatabase db = helper.getReadableDatabase(); //modo lectura
		Cursor cursor = db.query(MyDatabase.TABLE_NOTES,
				new String[]{MyDatabase.KEY_ID, MyDatabase.KEY_NAME,
						MyDatabase.KEY_DESC, MyDatabase.KEY_PATH},
				MyDatabase.KEY_ID + "=?",
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
		String sql= "SELECT  * FROM " + MyDatabase.TABLE_NOTES;
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
		String sql= "SELECT * FROM "+MyDatabase.TABLE_NOTES;
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		int count=cursor.getCount();
		cursor.close();
		db.close();
		return count;
	}
	
	//--------------------------------------------
	public int updateNote(NoteEntity noteEntity)
	{
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(MyDatabase.KEY_NAME, noteEntity.getName());
		values.put(MyDatabase.KEY_DESC, noteEntity.getDescription());
		values.put(MyDatabase.KEY_PATH, noteEntity.getPath());

		int row =db.update(MyDatabase.TABLE_NOTES,
				values,
				MyDatabase.KEY_ID+"=?",
				new String[]{String.valueOf(noteEntity.getId())});
		db.close();

		return row;
	}

	//--------------------------------------------
	public int deleteNote(NoteEntity noteEntity)
	{
		 SQLiteDatabase db = helper.getWritableDatabase(); 
		 int row= db.delete(MyDatabase.TABLE_NOTES,
				 MyDatabase.KEY_ID+"=?", 
				 new String[]{String.valueOf(noteEntity.getId())});
		 db.close();
		return row;
	}

	public long getNoteCountWithStatement(){
		String sql= "select count(*) from "+MyDatabase.TABLE_NOTES;
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
		clearTable(MyDatabase.TABLE_NOTES);
		//clearTable(MyDatabase.TABLE_USER);
	}
}
