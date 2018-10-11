package com.emedinaa.myfirstapp.fragments.listener;

import com.emedinaa.myfirstapp.model.NoteDbEntity;
import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.NoteRepository;

/**
 * Created by emedinaa on 15/09/15.
 */
public interface OnNoteListener {

     NoteRepository getNoteRepository();
     void deleteNote(NoteDbEntity noteDbEntity);
     void editNote(NoteDbEntity noteDbEntity);

     void editNoteNetwork(NoteEntity noteEntity);
     void deleteNoteNetwork(NoteEntity noteEntity);

     void showLoading();
     void hideLoading();
}
