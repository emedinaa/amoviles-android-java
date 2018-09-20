package com.emedinaa.myfirstapp.storage;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.emedinaa.myfirstapp.model.NoteEntity;


/**
 * @author Eduardo Medina
 */

@Database(entities = {NoteEntity.class}, version = 2)
public  abstract class NoteDataBase extends RoomDatabase {

    public abstract NoteDao noteDao();

    private static NoteDataBase INSTANCE;

    static NoteDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoteDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDataBase.class, "BDRoomNote")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     */
    private static Callback sRoomDatabaseCallback = new Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
           //clearNotes(INSTANCE);
        }

    };

    private static void clearNotes(@NonNull NoteDataBase db) {
        NoteDao noteDao= db.noteDao();
        noteDao.deleteAll();
    }

}
