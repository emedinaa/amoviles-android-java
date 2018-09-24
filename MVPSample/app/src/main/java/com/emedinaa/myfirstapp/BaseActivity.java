package com.emedinaa.myfirstapp;

import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected void enabledBack(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
