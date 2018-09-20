package com.emedinaa.myfirstapp.storage;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.emedinaa.myfirstapp.model.NoteEntity;
import java.util.List;

/**
 * Created by emedinaa on 2/25/18.
 */


@Dao
public interface NoteDao {

    @Insert
    void insert(NoteEntity note);

    @Insert
    void insertAll(NoteEntity... notes);

    @Update
    void update(NoteEntity note);

    @Update
    public void updateNotes(NoteEntity... notes);

    @Delete
    void delete(NoteEntity note);

    @Delete
    public void deleteNotes(NoteEntity... notes);

    @Query("DELETE FROM tb_notes")
    void deleteAll();

    /**
     Error
     @Query("SELECT * FROM user")
     List<NoteEntity> getAll();
     Error:(43, 22) error: There is a problem with the query: [SQLITE_ERROR] SQL error or missing database (no such table: user)
     */

    @Query("SELECT * FROM tb_notes")
    List<NoteEntity> getAll();

    @Query("select count(*) from tb_notes")
    long notesCounter();
    /*
    @Query("SELECT * FROM user WHERE age > :minAge")

    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public User[] loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search "
           + "OR last_name LIKE :search")
    public List<User> findUserWithName(String search)
     */

}
