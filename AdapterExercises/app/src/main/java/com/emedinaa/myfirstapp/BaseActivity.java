package com.emedinaa.myfirstapp;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by eduardomedina on 20/02/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected void enabledBack(){
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
