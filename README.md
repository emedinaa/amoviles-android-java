## Lesson 10 - Thursday, September 20, 2018

- Review

- Lesson

- Samples

- Homework

- Resources

## Review

¿Qué temas vimos en la clase pasada ?

Activities


## Lesson

Storage Options

- (en)https://developer.android.com/guide/topics/data/data-storage
- (es)https://developer.android.com/guide/topics/data/data-storage?hl=es-419

DB Sqlite

Otra forma de persistir información es usando una base de datos local (SQLITE), donde puedes usar el lenguaje SQL y realizar las operaciones que necesites para manejar una BD en tu APP.

Lo primero, es crear una BD, donde definimos el nombre y versión, asi como las tablas

```java
package com.belatrix.kotlintemplate.storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {


    public static final int DATABASE_VERSION = 1;
 
    public static final String DATABASE_NAME = "BDNote";
 
    public static final String TABLE_NOTES = "tb_notes";
    
    //Columnas de la Tabla Notes
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DESC = "desc";
    public static final String KEY_PATH = "path";
    
    
    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql= "CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_NAME + " TEXT,"
                + KEY_DESC + " TEXT,"
                + KEY_PATH + " TEXT" + ")";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        String sql= "DROP TABLE IF EXISTS " + TABLE_NOTES;
        db.execSQL(sql);
    }

}
```
Con la BD creada , requerimos definir una entidad que represente a un de las tablas y otra clase para manejar las operaciones sobre ella (CRUD)

Entidad :

```java
public class NoteEntity implements Serializable {

    private int id;
    private String name;
    private String description;
    private String path;

    public NoteEntity() {
    }

    public NoteEntity(int id, String name, String description, String path) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
    }

    public NoteEntity(String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "NoteEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
```

Operaciones (CRUD)

```java
public class CRUDOperations {

    private MyDatabase helper;
    public CRUDOperations(SQLiteOpenHelper _helper) {
        super();
        // TODO Auto-generated constructor stub
        helper =(MyDatabase)_helper;
}
...
```

Por ejemplo, para agregar un registro

```java
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
```

Editar un registro

```java
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
```

Obtener un registro
```java
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
```

Obtener todos los registros

```java
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
```

Borrar un registro

```java
  public int deleteNote(NoteEntity noteEntity)
    {
       SQLiteDatabase db = helper.getWritableDatabase(); 
       int row= db.delete(MyDatabase.TABLE_NOTES,
           MyDatabase.KEY_ID+"=?", 
           new String[]{String.valueOf(noteEntity.getId())});
       db.close();
      return row;
  }
```

## Samples

## Exercises

## Homework
- xxxx

## Resources 

- Storage Options https://developer.android.com/guide/topics/data/data-storage.html

- Save Data using SQLite https://developer.android.com/training/data-storage/sqlite.html

- Saving data in local database using Room https://developer.android.com/training/data-storage/room/index.html

- ORMLite http://ormlite.com/

- SugarORM http://satyan.github.io/sugar/

- Realm https://realm.io/docs

- Save Key-Value Data with SharedPreferences https://developer.android.com/training/data-storage/shared-preferences.html#java

- Save Data using SQLite https://developer.android.com/training/data-storage/sqlite.html



