package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by emedinaa on 15/02/17.
 */

public abstract class BaseActivity extends AppCompatActivity {

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
}
