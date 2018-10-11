package com.emedinaa.myfirstapp.storage.network;

import com.emedinaa.myfirstapp.storage.network.entity.NoteResponse;
import com.emedinaa.myfirstapp.storage.network.entity.NotesResponse;
import com.google.gson.GsonBuilder;

/**
 * Created by eduardomedina on 1/03/18.
 */

public class GsonHelper {

    public static NotesResponse jsonToNotesResponse (String json){
        if(json==null){
            return new NotesResponse();
        }
        GsonBuilder gson = new GsonBuilder();
        //Type collectionType = new TypeToken<T>(){}.getType();
        NotesResponse notesResponse = gson.create().fromJson(json, NotesResponse.class);

        return notesResponse;
    }

    public static NoteResponse jsonToNoteResponse (String json){
        if(json==null){
            return new NoteResponse();
        }
        GsonBuilder gson = new GsonBuilder();
        NoteResponse noteResponse = gson.create().fromJson(json, NoteResponse.class);

        return noteResponse;
    }
}
