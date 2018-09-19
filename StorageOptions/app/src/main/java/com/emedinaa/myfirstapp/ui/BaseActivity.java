package com.emedinaa.myfirstapp.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.emedinaa.myfirstapp.SOApplication;
import com.emedinaa.myfirstapp.storage.MySharedPreferences;

/**
 * Created by emedinaa on 2/22/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected void enabledBack(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    private MySharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = ((SOApplication)getApplication()).getSharedPreferences();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    protected MySharedPreferences sp(){
        return sharedPreferences;
    }
}
