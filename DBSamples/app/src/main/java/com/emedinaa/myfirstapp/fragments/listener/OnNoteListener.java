package com.emedinaa.myfirstapp.fragments.listener;


import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.CRUDOperations;

/**
 * Created by emedinaa on 15/09/15.
 */
public interface OnNoteListener {

     CRUDOperations getCrudOperations();
     void deleteNote(NoteEntity noteEntity);
     void editNote(NoteEntity noteEntity);
}
