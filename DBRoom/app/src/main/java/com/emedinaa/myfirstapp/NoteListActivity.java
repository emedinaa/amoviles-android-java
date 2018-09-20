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
import android.widget.Toast;

import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.NoteRepository;
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
    private NoteAdapter noteAdapter;
    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        init();
        //populate();
        //populateRoom();
        //loadData();
        //loadDataRoom();
    }

    private void loadDataRoom() {
        noteRepository= ((NoteApplication)(getApplication())).getNoteRepository();

        noteRepository.getAllNotes(new NoteRepository.PopulateCallback() {
            @Override
            public void onSuccess(List<NoteEntity> noteEntities) {
                renderNotes(noteEntities);
            }

            @Override
            public void onFailure(Exception e) {
                showErrorMessage(e.toString());
            }
        });
    }
    private void renderNotes(List<NoteEntity> noteEntities){
        lsNoteEntities= noteEntities;
        noteAdapter= new NoteAdapter(this,lsNoteEntities);
        lstNotes.setAdapter(noteAdapter);
    }

    private void showErrorMessage(String error){
        Toast.makeText(this,"Error : "+error,Toast.LENGTH_SHORT).show();
    }

    /* Error
    Caused by: java.lang.IllegalStateException: Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
     */
    private void populateRoom() {
        noteRepository= ((NoteApplication)(getApplication())).getNoteRepository();

        //new NoteEntity("Mi Nota","Esta es un nota ",null)
        noteRepository.addNotes(new NoteEntity(1,"Mi Nota","Esta es un nota ",null),
        new NoteEntity(2,"Segunda Nota","Esta es la segunds nota ",null),
        new NoteEntity(3,"Tercera Nota","Esta es la tercera nota ",null),
        new NoteEntity(4,"Cuarta Nota","Esta es la cuarta nota ",null),
        new NoteEntity(5,"Quinta Nota","Esta es la quinta nota ",null),
        new NoteEntity(6,"Sexta Nota","Esta es la sexta nota ",null));

        //Log.v(TAG, "populate " + crudOperations.getAllNotes());
    }

    private void init() {
        tviLogout= (TextView)findViewById(R.id.tviLogout);
        tviUser= (TextView)findViewById(R.id.tviUser);
        lstNotes= (ListView)(findViewById(R.id.lstNotes));
        btnAddNote= (Button)(findViewById(R.id.btnAddNote));

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
        loadDataRoom();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "MainActivity onPause - 1");
    }
}
