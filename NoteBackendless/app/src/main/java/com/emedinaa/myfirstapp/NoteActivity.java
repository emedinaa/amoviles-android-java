package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.emedinaa.myfirstapp.fragments.AddNoteFragment;
import com.emedinaa.myfirstapp.fragments.DetailsFragment;
import com.emedinaa.myfirstapp.fragments.listener.OnNoteListener;
import com.emedinaa.myfirstapp.model.NoteBLEntity;
import com.emedinaa.myfirstapp.storage.NoteRepository;
import com.emedinaa.myfirstapp.storage.network.ApiClient;
import com.emedinaa.myfirstapp.storage.network.StorageConstant;
import com.emedinaa.myfirstapp.storage.network.entity.NoteBLRaw;
import com.emedinaa.myfirstapp.storage.network.entity.NoteBLResponse;
import com.emedinaa.myfirstapp.storage.preferences.PreferencesHelper;
import com.emedinaa.myfirstapp.ui.dialogs.MyDialogFragment;
import com.emedinaa.myfirstapp.ui.dialogs.MyDialogListener;

import java.util.HashMap;
import java.util.Map;

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
    private NoteBLEntity currentNote;
    private NoteBLEntity noteEntity;

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
            noteEntity = (NoteBLEntity) getIntent().getExtras().getSerializable("NOTE");
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
    public void deleteNoteNetwork(NoteBLEntity mNoteEntity) {

        currentNote= mNoteEntity;
        MyDialogFragment myDialogFragment =new MyDialogFragment();
        Bundle bundle= new Bundle();
        bundle.putString("TITLE","¿Deseas eliminar esta nota?");
        bundle.putInt("TYPE",100);

        myDialogFragment.setArguments(bundle);
        myDialogFragment.show(getSupportFragmentManager(), "dialog");

    }

    //{"deletionTime":1520383459849}
    private void removeNote(NoteBLEntity mNoteEntity){
        showLoading();
        String token= PreferencesHelper.getTokenSession(this);
        Map<String, String> map = new HashMap<>();
        map.put("user-token",token);

        String noteId= mNoteEntity.getObjectId();
        Call<NoteBLResponse> call = ApiClient.getMyApiClient().deleteNoteBL(
                StorageConstant.APPLICATIONID, StorageConstant.RESTAPIKEY,map,
                noteId);
        call.enqueue(new Callback<NoteBLResponse>() {
            @Override
            public void onResponse(Call<NoteBLResponse> call, Response<NoteBLResponse> response) {
                hideLoading();
                if(response!=null && response.isSuccessful()){
                    exitActivity();
                }
            }

            @Override
            public void onFailure(Call<NoteBLResponse> call, Throwable t) {
                hideLoading();
                showMessage(t.getMessage());
            }
        });
        /*Call<NoteResponse> call= ApiClient.getMyApiClient().deleteNote(noteId);

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
        });*/
    }

    /*
    {"created":1512173921722,"___class":"Note","description":"123456","title":"Editar prueba","ownerId":"B0254EE8-CC3E-EDD8-FF5A-423577F08F00","updated":1520383039057,"objectId":"6E6B29CC-9DD7-C632-FFE5-FB46E94F4B00"}
     */
    @Override
    public void editNoteNetwork(NoteBLEntity mNoteEntity) {
        showLoading();
        String token= PreferencesHelper.getTokenSession(this);
        Map<String, String> map = new HashMap<>();
        map.put("user-token",token);

        String noteId = mNoteEntity.getObjectId();
        NoteBLRaw noteRaw= new NoteBLRaw();
        noteRaw.setTitle(mNoteEntity.getTitle());
        noteRaw.setDescription(mNoteEntity.getDescription());

        Call<NoteBLResponse> call= ApiClient.getMyApiClient().updateNoteBL(
                StorageConstant.APPLICATIONID, StorageConstant.RESTAPIKEY,map,
                noteId,noteRaw);

        call.enqueue(new Callback<NoteBLResponse>() {
            @Override
            public void onResponse(Call<NoteBLResponse> call, Response<NoteBLResponse> response) {
                hideLoading();
                if(response!=null && response.isSuccessful()){
                    exitActivity();
                }
            }

            @Override
            public void onFailure(Call<NoteBLResponse> call, Throwable t) {
                hideLoading();
                showMessage(t.getMessage());
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
