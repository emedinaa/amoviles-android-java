package com.emedinaa.myfirstapp;

import android.os.Bundle;

import com.emedinaa.myfirstapp.ui.BaseActivity;

public class DashboardActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        enabledBack();
    }
}
