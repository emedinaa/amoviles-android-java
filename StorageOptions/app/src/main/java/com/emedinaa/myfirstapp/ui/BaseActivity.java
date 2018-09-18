package com.emedinaa.myfirstapp.ui;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by emedinaa on 2/22/18.
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
