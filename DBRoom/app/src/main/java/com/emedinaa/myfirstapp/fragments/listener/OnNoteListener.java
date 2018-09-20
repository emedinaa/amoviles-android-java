package com.emedinaa.myfirstapp.fragments.listener;

import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.NoteRepository;

/**
 * Created by emedinaa on 15/09/15.
 */
public interface OnNoteListener {

     NoteRepository getNoteRepository();
     void deleteNote(NoteEntity noteEntity);
     void editNote(NoteEntity noteEntity);
}
