package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

public class AdapterBasicIIIActivity extends BaseActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_basic_03);
        enabledBack();
        recyclerView= findViewById(R.id.recyclerView);
    }
}
