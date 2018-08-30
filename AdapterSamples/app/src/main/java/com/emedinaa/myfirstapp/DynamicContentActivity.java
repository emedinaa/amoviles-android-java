package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.emedinaa.myfirstapp.adapter.DynamicContentAdapter;

import java.util.LinkedList;

public class DynamicContentActivity extends BaseActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView recyclerview;
    private FloatingActionButton fab;
    private DynamicContentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_content);
        enabledBack();
        setUpData();
        ui();
        populate();
    }

    private void populate() {

        // Create an adapter and supply the data to be displayed.
        mAdapter = new DynamicContentAdapter(this, mWordList);
        // Connect the adapter with the recycler view.
        recyclerview.setAdapter(mAdapter);

    }

    private void ui() {
        recyclerview = findViewById(R.id.recyclerview);
        fab = findViewById(R.id.fab);

        //recyclerview layout
        recyclerview.setLayoutManager(new LinearLayoutManager(this));

        //events
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wordListSize = mWordList.size();
                // Add a new word to the wordList.
                mWordList.addLast("+ Word " + wordListSize);
                // Notify the adapter, that the data has changed.
                recyclerview.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                recyclerview.smoothScrollToPosition(wordListSize);
            }
        });
    }

    private void setUpData(){
        // Put initial data into the word list.
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + i);
        }
    }
}
