package com.emedinaa.myfirstapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.fragments.listener.OnNoteListener;
import com.emedinaa.myfirstapp.model.NoteDbEntity;
import com.emedinaa.myfirstapp.storage.network.ApiClient;
import com.emedinaa.myfirstapp.storage.network.GsonHelper;
import com.emedinaa.myfirstapp.storage.network.entity.NoteRaw;
import com.emedinaa.myfirstapp.storage.network.entity.NoteResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AddNoteFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private EditText eteName;
    private EditText eteDesc;
    private EditText eteNote;
    private Button btnAddNote;

    private String name;
    private String desc;
    private String note;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnNoteListener mListener;

    // TODO: Rename and change types and number of parameters
    public static AddNoteFragment newInstance(String param1, String param2) {
        AddNoteFragment fragment = new AddNoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AddNoteFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_note, container, false);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (OnNoteListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        eteName=getView().findViewById(R.id.eteName);
        eteDesc=getView().findViewById(R.id.eteDesc);
        eteNote=getView().findViewById(R.id.eteNote);
        btnAddNote=getView().findViewById(R.id.btnAddNote);

        //events
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validateForm()){
                    addNoteNetwork();
                }
            }
        });
        eteDesc.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(event!=null){
                    Log.v("CONSOLE ","keycode "+event.getKeyCode()+
                            " actionId "+actionId);
                }

                if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) || (actionId == EditorInfo.IME_ACTION_DONE)) {
                    if(validateForm()){
                        addNoteNetwork();
                    }
                }
                return false;
            }
        });
    }

    private boolean validateForm(){
        //ui
        clearForm();
        name= eteName.getText().toString().trim();
        desc= eteDesc.getText().toString().trim();
        note= eteNote.getText().toString().trim();

        if(name.isEmpty()){
            eteName.setError("Nombre inválido");
            return false;
        }
        if(desc.isEmpty()){
            eteDesc.setError("Descripción inválido");
            return false;
        }

        return true;
    }

    private void clearForm() {
        eteName.setError(null);
        eteDesc.setError(null);
    }

    private void addNote() {
        //bd
        NoteDbEntity noteDbEntity = new NoteDbEntity(name,desc,null);
        mListener.getNoteRepository().add(noteDbEntity);
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                if(validateForm()){
                    addNoteNetwork();
                }
                return true;
            default:

        }
        return super.onOptionsItemSelected(item);
    }*/

    /*
            POST https://obscure-earth-55790.herokuapp.com/api/notes/register
            {"msg":"error Need a userId param"}
         */
    private void addNoteNetwork(){
        showLoading();
        NoteRaw noteRaw= new NoteRaw();
        noteRaw.setName(name);
        noteRaw.setDescription(desc);
        noteRaw.setUserId("001");
        Call<NoteResponse> call= ApiClient.getMyApiClient().addNote(noteRaw);

        call.enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                hideLoading();
                if(response!=null){
                    NoteResponse noteResponse=null;

                    if(response.isSuccessful()) {
                        closeActivity();
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
                Toast.makeText(getActivity(),
                        "error "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

    }

    private void showMessage(String message){
        Toast.makeText(getActivity(),
                "error "+message,Toast.LENGTH_LONG).show();
    }

    private void showLoading(){
        if(mListener!=null){
            mListener.showLoading();
        }
    }

    private void hideLoading(){
        if(mListener!=null){
            mListener.hideLoading();
        }
    }

    private void closeActivity(){
        getActivity().finish();
    }
}
