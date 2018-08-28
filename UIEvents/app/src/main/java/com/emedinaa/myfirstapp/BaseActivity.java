package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by eduardomedina on 5/23/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    protected void next(Class<?> activityClass, Bundle bundle, boolean destroy){
        Intent intent= new Intent(this, activityClass);
        if(bundle!=null){
            intent.putExtras(bundle);
        }
        startActivity(intent);
        if (destroy) {
            finish();
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
