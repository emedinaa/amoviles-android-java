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
import com.emedinaa.myfirstapp.storage.network.ApiClient;
import com.emedinaa.myfirstapp.storage.network.GsonHelper;
import com.emedinaa.myfirstapp.storage.network.StorageConstant;
import com.emedinaa.myfirstapp.storage.network.entity.NotesBLResponse;
import com.emedinaa.myfirstapp.storage.network.entity.NotesResponse;
import com.emedinaa.myfirstapp.storage.preferences.PreferencesHelper;
import com.emedinaa.myfirstapp.ui.adapters.NoteAdapter;
import com.emedinaa.myfirstapp.ui.adapters.NoteBLAdapter;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoteListActivity extends AppCompatActivity {

    private final String TAG="NoteList";
    private static final int ACTION_ADD=1;
    private static final int ACTION_DETAIL=2;

    private TextView tviLogout,tviUser;
    private ListView lstNotes;
    private Button btnAddNote;
    private List<NoteEntity> notes;
    private NoteAdapter noteAdapter;

    private List<NoteBLEntity> lsNoteEntities;
    private NoteBLAdapter noteAdapterBL;
    private View flayLoading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_list);
        init();
    }

    private void loadDataBackendless(){
        showLoading();

        String token= PreferencesHelper.getTokenSession(this);

        Map<String, String> map = new HashMap<>();
        map.put("user-token",token);
        Call<NotesBLResponse> call= ApiClient.getMyApiClient().notesbl(
                StorageConstant.APPLICATIONID, StorageConstant.RESTAPIKEY,map);

        call.enqueue(new Callback<NotesBLResponse>() {
            @Override
            public void onResponse(Call<NotesBLResponse> call, Response<NotesBLResponse> response) {
                hideLoading();
                if(response!=null){
                    NotesBLResponse notesResponse=null;
                    if(response.isSuccessful()){
                        notesResponse= response.body();
                        renderNotesBL(notesResponse);
                    }else{
                    }
                }
            }

            @Override
            public void onFailure(Call<NotesBLResponse> call, Throwable t) {
                hideLoading();
                showMessage(t.getMessage());
            }
        });
    }

    private void loadDataNetwork(){
        showLoading();
        Call<NotesResponse> call= ApiClient.getMyApiClient().notes();
        call.enqueue(new Callback<NotesResponse>() {
            @Override
            public void onResponse(Call<NotesResponse> call, Response<NotesResponse> response) {
                hideLoading();

                if(response!=null){
                    NotesResponse notesResponse=null;

                    if(response.isSuccessful()){
                        notesResponse=response.body();
                        if(notesResponse!=null){
                            if(notesResponse.getStatus()==200){
                                Log.v("CONSOLE", "success "+notesResponse);
                                renderNotes(notesResponse.getData());
                            }else{
                                Log.v("CONSOLE", "error "+notesResponse);
                            }
                        }
                    }else{
                        Log.v("CONSOLE", "error "+notesResponse);
                        JSONObject jsonObject = null;
                        try {
                            jsonObject=new JSONObject(response.errorBody().string());
                        }catch (Exception e){
                            jsonObject= new JSONObject();
                        }

                        notesResponse= GsonHelper.jsonToNotesResponse(jsonObject.toString());
                        showErrorMessage(notesResponse.getMsg());
                    }
                }else{
                    showErrorMessage("Ocurrió un error");
                }
            }

            @Override
            public void onFailure(Call<NotesResponse> call, Throwable t) {
                hideLoading();
                Toast.makeText(NoteListActivity.this,
                        "error "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void renderNotes(List<NoteEntity> noteEntities){
        notes= noteEntities;
        noteAdapter = new NoteAdapter(this,notes);
        lstNotes.setAdapter(noteAdapter);
    }

    private void renderNotesBL(List<NoteBLEntity> mNotes){
        Log.v("CONSOLE", "renderNotes");
        lsNoteEntities= mNotes;
        noteAdapterBL= new NoteBLAdapter(this,lsNoteEntities);
        lstNotes.setAdapter(noteAdapterBL);
    }

    private void showErrorMessage(String error){
        Toast.makeText(this,"Error : "+error,Toast.LENGTH_SHORT).show();
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
                gotoNote(ACTION_ADD, null);
            }
        });

        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoteBLEntity noteEntity = (NoteBLEntity) adapterView.getAdapter().getItem(i);
                gotoNote(ACTION_DETAIL, noteEntity);
            }
        });

        tviLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }

    private void showLoading(){
        flayLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading(){
        flayLoading.setVisibility(View.GONE);
    }

    private void logout() {
        PreferencesHelper.signOut(this);
        startActivity(new Intent(this, LogInActivity.class));
        finish();
    }

    private void gotoNote(int action, NoteBLEntity noteEntity) {
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

    private void showMessage(String message){
        Toast.makeText(this,
                "LogIn "+message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadDataBackendless();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
