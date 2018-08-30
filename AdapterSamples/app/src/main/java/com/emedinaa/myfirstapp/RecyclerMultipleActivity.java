package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.emedinaa.myfirstapp.adapter.MultipleRecyclerAdapter;
import com.emedinaa.myfirstapp.data.MultipleData;
import com.emedinaa.myfirstapp.model.TypeEntity;

import java.util.List;

public class RecyclerMultipleActivity extends BaseActivity {

    private RecyclerView rviewMultiple;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_multiple);
        enabledBack();

        ui();
        getObjects();
    }

    private void getObjects() {

        MultipleData multipleRepo= new MultipleData();
        List<TypeEntity> objects= multipleRepo.getObjects();

        // specify an adapter (see also next example)
        adapter = new MultipleRecyclerAdapter(objects);
        rviewMultiple.setAdapter(adapter);

    }

    private void ui() {
        rviewMultiple= (RecyclerView) findViewById(R.id.rviewMultiple);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        rviewMultiple.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);

        // use a grid layout manager
        //mLayoutManager = new GridLayoutManager(this,2);

        rviewMultiple.setLayoutManager(mLayoutManager);
    }
}
