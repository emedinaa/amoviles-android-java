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

import com.emedinaa.myfirstapp.model.NoteBLEntity;
import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.presenter.NoteListPresenter;
import com.emedinaa.myfirstapp.presenter.NoteListView;
import com.emedinaa.myfirstapp.storage.preferences.PreferencesHelper;
import com.emedinaa.myfirstapp.ui.adapters.NoteBLAdapter;

import java.util.List;

/**
 * Created by eduardomedina on 13/03/18.
 */

public class NoteListMVPActivity extends AppCompatActivity
        implements NoteListView {

    private final String TAG="NoteList";
    private static final int ACTION_ADD=1;
    private static final int ACTION_DETAIL=2;

    private TextView tviLogout,tviUser;
    private ListView lstNotes;
    private Button btnAddNote;
    private List<NoteEntity> notes;

    private List<NoteBLEntity> lsNoteEntities;
    private NoteBLAdapter noteAdapterBL;
    private View flayLoading;

    private NoteListPresenter noteListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        setUpPresenter();
        init();
        loadNotes();

    }

    private void loadNotes(){
        String token= PreferencesHelper.getTokenSession(this);
        noteListPresenter.loadDataBackendless(token);
    }

    private void setUpPresenter(){
        noteListPresenter= new NoteListPresenter(new PreferencesHelper());
        noteListPresenter.attachView(this);
    }

    private void init() {
        tviLogout= findViewById(R.id.tviLogout);
        tviUser= findViewById(R.id.tviUser);
        lstNotes= findViewById(R.id.lstNotes);
        btnAddNote= findViewById(R.id.btnAddNote);
        flayLoading= findViewById(R.id.flayLoading);

        //events
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //gotoNote(ACTION_ADD, null);
            }
        });

        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoteBLEntity noteEntity = (NoteBLEntity) adapterView.getAdapter().getItem(i);
                //gotoNote(ACTION_DETAIL, noteEntity);
            }
        });

        tviLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //logout();
                noteListPresenter.logout();
            }
        });
    }

    @Override
    public void renderNotesBL(List<NoteBLEntity> mNotes) {
        Log.v("CONSOLE", "renderNotes");
        lsNoteEntities= mNotes;
        noteAdapterBL= new NoteBLAdapter(this,lsNoteEntities);
        lstNotes.setAdapter(noteAdapterBL);
    }

    @Override
    public void showErrorMessage(String error) {
        Toast.makeText(this,"Error : "+error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this,
                "LogIn "+message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        flayLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        flayLoading.setVisibility(View.GONE);
    }

    @Override
    public void goToNote(int action, NoteBLEntity noteEntity) {
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
    public void logOut() {
        PreferencesHelper.signOut(this);
        //startActivity(new Intent(this, LogInActivity.class));
        startActivity(new Intent(this, LogInMVPActivity.class));
        finish();
    }

    @Override
    public void emptyNotes() {
        //mostrar mensaje que la lista vacía
    }
}
