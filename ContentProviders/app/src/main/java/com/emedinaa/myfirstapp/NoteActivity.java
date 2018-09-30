package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;

import com.emedinaa.myfirstapp.fragments.AddNoteFragment;
import com.emedinaa.myfirstapp.fragments.DetailsFragment;
import com.emedinaa.myfirstapp.fragments.listener.OnNoteListener;
import com.emedinaa.myfirstapp.model.NoteEntity;
import com.emedinaa.myfirstapp.storage.CRUDOperations;
import com.emedinaa.myfirstapp.storage.NoteDbHelper;
import com.emedinaa.myfirstapp.ui.dialogs.MyDialogFragment;
import com.emedinaa.myfirstapp.ui.dialogs.MyDialogListener;


public class NoteActivity extends BaseActivity implements OnNoteListener, MyDialogListener {

    public static final  int ADD_NOTE=100;
    public static final  int DETAIL_NOTE=101;
    public static final  int UPDATE_NOTE=102;

    private static final String TAG ="NoteActivity";

    private AddNoteFragment addNoteFragment= AddNoteFragment.newInstance(null,null);
    private DetailsFragment detailsFragment= DetailsFragment.newInstance(null,null);
    private int fragmentSelected= DETAIL_NOTE;
    private NoteEntity noteEntity;
    private NoteEntity currentNote;


    private CRUDOperations crudOperations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        validateExtras();
        enabledBack();
        crudOperations= new CRUDOperations(new NoteDbHelper(this));
        Bundle bundle= new Bundle();
        bundle.putSerializable("NOTE",noteEntity);
        changeFragment(fragmentSelected, bundle);
    }

    private void validateExtras() {
        if(getIntent().getExtras()!=null)
        {
            fragmentSelected= getIntent().getExtras().getInt("FRAGMENT",DETAIL_NOTE);
            noteEntity= (NoteEntity)getIntent().getExtras().getSerializable("NOTE");
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
    public CRUDOperations getCrudOperations() {
        return crudOperations;
    }

    @Override
    public void deleteNote(NoteEntity noteEntity) {

        currentNote= noteEntity;
        MyDialogFragment myDialogFragment =new MyDialogFragment();
        Bundle bundle= new Bundle();
        bundle.putString("TITLE","¿Deseas eliminar esta nota?");
        bundle.putInt("TYPE",100);

        myDialogFragment.setArguments(bundle);
        myDialogFragment.show(getSupportFragmentManager(), "dialog");
    }

    @Override
    public void editNote(NoteEntity noteEntity) {
        crudOperations.updateNote(noteEntity);
    }

    @Override
    public void onPositiveListener(Object object, int type) {
        Log.v("CONSOLE", "dialog positive");
        if(currentNote!=null) {
            crudOperations.deleteNote(currentNote);
            currentNote=null;
            finish();
        }
    }

    @Override
    public void onNegativeListener(Object object, int type) {
        Log.v(TAG, "dialog negative");
    }
}
