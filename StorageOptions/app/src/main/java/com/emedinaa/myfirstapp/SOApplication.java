package com.emedinaa.myfirstapp;

import android.app.Application;

import com.emedinaa.myfirstapp.storage.MySharedPreferences;
import com.emedinaa.myfirstapp.storage.SOSharedPreferences;

public class SOApplication extends Application {

    private MySharedPreferences sharedPreferences;
    @Override
    public void onCreate() {
        super.onCreate();
        setupStoreOptions();
        //injectStoreOptions();
    }

    private void setupStoreOptions(){
        //shared preferences
        //db
        //http client
        sharedPreferences= new SOSharedPreferences();
        sharedPreferences.setup(this);
    }

    public MySharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
