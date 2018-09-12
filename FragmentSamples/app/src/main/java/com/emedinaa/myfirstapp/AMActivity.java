package com.emedinaa.myfirstapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AMActivity extends AppCompatActivity {

    private Fragment fragmentL, fragmentR;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_am);
        //setContentView(R.layout.activity_am_land);

        fragmentManager=getSupportFragmentManager();
        //fragmentL
        fragmentL= fragmentManager.findFragmentById(R.id.fragmentL);
        fragmentR= fragmentManager.findFragmentById(R.id.fragmentR);

        if(fragmentR==null){
            //mobile
        }else{
            //tablet
        }
    }
}
