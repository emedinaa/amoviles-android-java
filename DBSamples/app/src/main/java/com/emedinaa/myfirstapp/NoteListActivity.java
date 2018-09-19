package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.CRUDOperations;
import com.emedinaa.myfirstapp.storage.MyDatabase;
import com.emedinaa.myfirstapp.ui.adapters.NoteAdapter;

import java.util.List;

public class NoteListActivity extends AppCompatActivity {

    private final String TAG="NoteList";
    private static final int ACTION_ADD=1;
    private static final int ACTION_DETAIL=2;

    private TextView tviLogout,tviUser;
    private ListView lstNotes;
    private Button btnAddNote;
    private List<NoteEntity> lsNoteEntities;
    private CRUDOperations crudOperations;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        init();
        //populate();
        loadData();
    }

    private void loadData() {
        crudOperations= new CRUDOperations(new MyDatabase(this));
        lsNoteEntities= crudOperations.getAllNotes();
        noteAdapter= new NoteAdapter(this,lsNoteEntities);
        lstNotes.setAdapter(noteAdapter);
    }

    private void populate() {

        CRUDOperations crudOperations= new CRUDOperations(new MyDatabase(this));
        crudOperations.addNote(new NoteEntity("Mi Nota","Esta es un nota ",null));
        crudOperations.addNote(new NoteEntity("Segunda Nota","Esta es la segunds nota ",null));
        crudOperations.addNote(new NoteEntity("Tercera Nota","Esta es la tercera nota ",null));
        crudOperations.addNote(new NoteEntity("Cuarta Nota","Esta es la cuarta nota ",null));
        crudOperations.addNote(new NoteEntity("Quinta Nota","Esta es la quinta nota ",null));
        crudOperations.addNote(new NoteEntity("Sexta Nota","Esta es la sexta nota ",null));

        Log.v(TAG, "populate " + crudOperations.getAllNotes());
    }

    private void init() {
        tviLogout= findViewById(R.id.tviLogout);
        tviUser= findViewById(R.id.tviUser);
        lstNotes= (findViewById(R.id.lstNotes));
        btnAddNote= (findViewById(R.id.btnAddNote));


        //events
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNote(ACTION_ADD, null);
            }
        });

        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoteEntity noteEntity = (NoteEntity) adapterView.getAdapter().getItem(i);
                gotoNote(ACTION_DETAIL, noteEntity);
            }
        });

    }

    private void gotoNote(int action, NoteEntity noteEntity) {
        Intent intent= new Intent(this,NoteActivity.class);

        switch (action)
        {
            case ACTION_ADD:
                intent.putExtra("FRAGMENT",NoteActivity.ADD_NOTE);
                startActivity(intent);
                break;
            case ACTION_DETAIL:
                intent.putExtra("FRAGMENT",NoteActivity.DETAIL_NOTE);
                intent.putExtra("NOTE", noteEntity);
                startActivity(intent);
                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "MainActivity onResumen - 2");
        //loadData();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "MainActivity onPause - 1");
    }
}
