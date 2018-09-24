package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.emedinaa.myfirstapp.fragments.AddNoteFragment;
import com.emedinaa.myfirstapp.fragments.DetailsFragment;
import com.emedinaa.myfirstapp.fragments.listener.OnNoteListener;
import com.emedinaa.myfirstapp.model.NoteDbEntity;
import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.NoteRepository;
import com.emedinaa.myfirstapp.storage.network.ApiClient;
import com.emedinaa.myfirstapp.storage.network.GsonHelper;
import com.emedinaa.myfirstapp.storage.network.entity.NoteRaw;
import com.emedinaa.myfirstapp.storage.network.entity.NoteResponse;
import com.emedinaa.myfirstapp.ui.dialogs.MyDialogFragment;
import com.emedinaa.myfirstapp.ui.dialogs.MyDialogListener;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class NoteActivity extends BaseActivity implements OnNoteListener, MyDialogListener {

    public static final  int ADD_NOTE=100;
    public static final  int DETAIL_NOTE=101;
    public static final  int UPDATE_NOTE=102;

    private static final String TAG ="NoteActivity";

    private AddNoteFragment addNoteFragment= AddNoteFragment.newInstance(null,null);
    private DetailsFragment detailsFragment= DetailsFragment.newInstance(null,null);
    private int fragmentSelected= DETAIL_NOTE;
    private NoteEntity currentNote;
    private NoteEntity noteEntity;

    private NoteRepository noteRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        validateExtras();
        enabledBack();
        noteRepository= ((NoteApplication)(getApplication())).getNoteRepository();

        Bundle bundle= new Bundle();
        bundle.putSerializable("NOTE", noteEntity);
        changeFragment(fragmentSelected, bundle);
    }

    private void validateExtras() {
        if(getIntent().getExtras()!=null)
        {
            fragmentSelected= getIntent().getExtras().getInt("FRAGMENT",DETAIL_NOTE);
            noteEntity = (NoteEntity) getIntent().getExtras().getSerializable("NOTE");
        }
    }


    private  void changeFragment(int id,Bundle bundle)
    {
        Fragment fragment= null;
        switch (id)
        {
            case ADD_NOTE:
                fragment=addNoteFragment;
                break;

            case DETAIL_NOTE:
                fragment=detailsFragment;
                break;

            case UPDATE_NOTE:
                fragment=null;
                break;
        }

        if(fragment!=null)
        {
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();
        }
    }


    @Override
    public NoteRepository getNoteRepository() {
        return noteRepository;
    }

    @Override
    public void deleteNote(NoteDbEntity noteDbEntity) {
    }

    @Override
    public void editNote(NoteDbEntity noteDbEntity) {}

    @Override
    public void deleteNoteNetwork(NoteEntity mNoteEntity) {

        currentNote= mNoteEntity;
        MyDialogFragment myDialogFragment =new MyDialogFragment();
        Bundle bundle= new Bundle();
        bundle.putString("TITLE","¿Deseas eliminar esta nota?");
        bundle.putInt("TYPE",100);

        myDialogFragment.setArguments(bundle);
        myDialogFragment.show(getSupportFragmentManager(), "dialog");

    }

    private void removeNote(NoteEntity mNoteEntity){
        showLoading();
        String noteId= mNoteEntity.getId();

        Call<NoteResponse> call= ApiClient.getMyApiClient().deleteNote(noteId);

        call.enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                hideLoading();
                if(response!=null){
                    NoteResponse noteResponse=null;

                    if(response.isSuccessful()) {
                        noteResponse = response.body();
                        if(noteResponse!=null && noteResponse.isSuccess()){
                            currentNote=null;
                            exitActivity();
                        }
                    }else{
                        JSONObject jsonObject = null;
                        try {
                            jsonObject=new JSONObject(response.errorBody().string());
                        }catch (Exception e){
                            jsonObject= new JSONObject();
                        }
                        noteResponse= GsonHelper.jsonToNoteResponse(jsonObject.toString());
                        showMessage(noteResponse.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<NoteResponse> call, Throwable t) {
                hideLoading();
                Toast.makeText(NoteActivity.this,
                        "error "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void editNoteNetwork(NoteEntity mNoteEntity) {
        showLoading();
        String noteId = mNoteEntity.getId();
        NoteRaw noteRaw= new NoteRaw();
        noteRaw.setId(mNoteEntity.getId());
        noteRaw.setName(mNoteEntity.getName());
        noteRaw.setDescription(mNoteEntity.getDescription());
        noteRaw.setUserId(mNoteEntity.getUserId());

        Call<NoteResponse> call= ApiClient.getMyApiClient().updateNote(noteId,noteRaw);

        call.enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                hideLoading();
                if(response!=null){
                    NoteResponse noteResponse=null;

                    if(response.isSuccessful()) {
                        exitActivity();
                    }else{
                        JSONObject jsonObject = null;
                        try {
                            jsonObject=new JSONObject(response.errorBody().string());
                        }catch (Exception e){
                            jsonObject= new JSONObject();
                        }
                        noteResponse= GsonHelper.jsonToNoteResponse(jsonObject.toString());
                        showMessage(noteResponse.getMsg());
                    }
                }
            }

            @Override
            public void onFailure(Call<NoteResponse> call, Throwable t) {
                hideLoading();
                Toast.makeText(NoteActivity.this,
                        "error "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showMessage(String message){
        Toast.makeText(this,
                "error "+message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPositiveListener(Object object, int type) {
        Log.v("CONSOLE", "dialog positive");
        if(currentNote==null) return;
        removeNote(currentNote);
    }

    @Override
    public void onNegativeListener(Object object, int type) {
        Log.v(TAG, "dialog negative");
    }

    @Override
    public void showLoading() {
        findViewById(R.id.flayLoading).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        findViewById(R.id.flayLoading).setVisibility(View.GONE);
    }

    private void exitActivity(){
        this.finish();
    }
}
