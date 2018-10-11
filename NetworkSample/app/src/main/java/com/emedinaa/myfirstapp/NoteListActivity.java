package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.NoteRepository;
import com.emedinaa.myfirstapp.storage.network.ApiClient;
import com.emedinaa.myfirstapp.storage.network.GsonHelper;
import com.emedinaa.myfirstapp.storage.network.entity.NotesResponse;
import com.emedinaa.myfirstapp.ui.adapters.NoteRVAdapter;
import com.emedinaa.myfirstapp.ui.events.ClickListener;
import com.emedinaa.myfirstapp.ui.events.RecyclerTouchListener;
import com.emedinaa.myfirstapp.utils.NLog;

import org.json.JSONObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NoteListActivity extends AppCompatActivity {

    private final String TAG="NoteList";
    private static final int ACTION_ADD=1;
    private static final int ACTION_DETAIL=2;

    private List<NoteEntity> notes;
    private NoteRVAdapter noteAdapter;
    private NoteRepository noteRepository;

    private View flayLoading;
    private SwipeRefreshLayout swiperefresh;
    private TextView tviLogout,tviUser;
    private RecyclerView recyclerViewNote;
    private Button btnAddNote;
    private FloatingActionButton fab;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_note_list);
        setContentView(R.layout.activity_note_list_behavior);
        init();
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

                    if(response.isSuccessful()){//200
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
                        //Log.v("CONSOLE", "error "+notesResponse);
                        NLog.v("error "+notesResponse);
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
        noteAdapter = new NoteRVAdapter(this,notes);
        recyclerViewNote.setAdapter(noteAdapter);
    }

    private void showErrorMessage(String error){
        Toast.makeText(this,"Error : "+error,Toast.LENGTH_SHORT).show();
    }

    private void init() {
        tviLogout= findViewById(R.id.tviLogout);
        tviUser= findViewById(R.id.tviUser);
        recyclerViewNote= findViewById(R.id.recyclerViewNote);
        btnAddNote= findViewById(R.id.btnAddNote);
        flayLoading= findViewById(R.id.flayLoading);
        swiperefresh= findViewById(R.id.swiperefresh);
        fab= findViewById(R.id.fab);

        mLayoutManager= new LinearLayoutManager(this);//,LinearLayoutManager.VERTICAL,)
        recyclerViewNote.setLayoutManager(mLayoutManager);
        //events
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNote(ACTION_ADD, null);
            }
        });


        recyclerViewNote.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewNote, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(notes!=null && !notes.isEmpty()){
                    NoteEntity noteEntity = (NoteEntity) notes.get(position);
                    gotoNote(ACTION_DETAIL, noteEntity);
                }
            }

            @Override
            public void onLongClick(View view, int position) {}
        }));

        tviLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });

        /*
         * Sets up a SwipeRefreshLayout.OnRefreshListener that is invoked when the user
         * performs a swipe-to-refresh gesture.
         */
        swiperefresh.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        Log.d("CONSOLE", "onRefresh called from SwipeRefreshLayout");

                        // This method performs the actual data-refresh operation.
                        // The method calls setRefreshing(false) when it's finished.
                        myUpdateOperation();
                    }
                }
        );

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNote(ACTION_ADD, null);
            }
        });
    }

    private void myUpdateOperation(){
        loadDataNetwork();
    }

    private void showLoading(){
        flayLoading.setVisibility(View.VISIBLE);
    }

    private void hideLoading(){
        swiperefresh.setRefreshing(false);

        flayLoading.setVisibility(View.GONE);
    }

    private void logout() {
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
        loadDataNetwork();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}
