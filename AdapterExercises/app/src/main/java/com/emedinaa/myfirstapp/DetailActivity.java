package com.emedinaa.myfirstapp;

import android.os.Bundle;

public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        enabledBack();
    }
}
