package com.emedinaa.myfirstapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.emedinaa.myfirstapp.storage.PreferencesHelper;


public class SPActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;

    private TextView textView;
    private Button buttonClear, buttonSave;

    private String mOperaciones="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp);
        app();
    }

    private void renderSP(){
        mOperaciones="";
        retrieveStringValue("USERNAME");
        retrieveStringValue("PASSWORD");

        textView.setText(mOperaciones);
    }

    private void saveSP(){
        saveStringKey("USERNAME","José");
        saveStringKey("PASSWORD","87654321");
    }

    private void clearSP(){
        clear();
    }

    private void ui(){
        textView= findViewById(R.id.textView);
        buttonClear= findViewById(R.id.buttonClear);
        buttonSave= findViewById(R.id.buttonSave);
        //textView.setText("TEXTO...");
        textView.setText("");

        //eventos
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //guardar
                saveSP();
                renderSP();
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //clear
                clearSP();
                renderSP();
            }
        });
    }

    private void app() {
        ui();
        setUpSharedPreferences();

        //PreferencesHelper.saveSession(this,"edu","123456");
        //boolean session= PreferencesHelper.isSignedIn(this);
        //String username= PreferencesHelper.getUserSession(this);

        //log("session "+session+ " username "+username);
        //save
        //saveStringKey("USERNAME","edu");
        //saveStringKey("PASSWORD","123456");

        //retrieve
        //retrieveStringValue("USERNAME");
        //retrieveStringValue("PASSWORD");

        //clear
        //clearKey("USERNAME");
        //clearKey("PASSWORD");
        //clear();
        //retrieveStringValue("PASSWORD");
        //retrieveStringValue("USERNAME");

        //textView.setText(mOperaciones);

        renderSP();
    }

    private void setUpSharedPreferences(){
        //getSharedPreferences("com.amoviles.sharedpref",Context.MODE_PRIVATE);
        sharedPreferences=getSharedPreferences("com.amoviles.sharedpref", Context.MODE_PRIVATE);
        //sharedPreferences=getSharedPreferences("DEMO", Context.MODE_APPEND);
        sharedPreferencesEditor= sharedPreferences.edit();
    }

    private void retrieveStringValue(String key){
        String value= sharedPreferences.getString(key,"Valor eliminado");

        log(String.format("retrieve key : %s , value : %s",key,value));

        mOperaciones+="\nRecibir  key "+key+ " value "+value;
    }

    private void retrieveIntValue(String key){
        int value= sharedPreferences.getInt(key,0);
        log(String.format("retrieve key : %s , value : %s",key,value));
    }

    private void retrieveBooleanValue(String key){
        boolean value= sharedPreferences.getBoolean(key,false);
        log(String.format("retrieve key : %s , value : %s",key,value));
    }

    private void saveStringKey(String key, String value){
        sharedPreferencesEditor.putString(key, value);
        sharedPreferencesEditor.apply();
        //sharedPreferencesEditor.commit();

        log(String.format("saved key : %s , value : %s",key,value));
        mOperaciones+= "\nGuardar key "+key+" value "+value;
    }

    private void saveIntKey(String key, int value){
        sharedPreferencesEditor.putInt(key, 0);
        sharedPreferencesEditor.apply();
        log(String.format("key : %s , value : %s",key,value));
    }

    private void saveBooleanKey(String key, boolean value){
        sharedPreferencesEditor.putBoolean(key, value);
        //sharedPreferencesEditor.apply();

        log(String.format("key : %s , value : %s",key,value));
    }

    private void clearKey(String key){
        sharedPreferencesEditor.remove(key);
        sharedPreferencesEditor.apply();
    }

    private void clear(){
        //sharedPreferencesEditor.remove(key);
        //sharedPreferencesEditor.remove(key);
        sharedPreferencesEditor.clear();
        sharedPreferencesEditor.apply();

        log("Clear...");
    }
    private void log(String message){
        if(message==null)return;
        Log.d("CONSOLE", message);
    }
}
