package com.emedinaa.myfirstapp;

import android.app.Application;

import com.emedinaa.myfirstapp.storage.NoteRepository;


/**
 * Created by eduardomedina on 27/02/18.
 */

public class NoteApplication extends Application {

    private NoteRepository noteRepository;

    @Override
    public void onCreate() {
        super.onCreate();
        noteRepository= new NoteRepository(this);
    }

    public NoteRepository getNoteRepository() {
        return noteRepository;
    }
}
