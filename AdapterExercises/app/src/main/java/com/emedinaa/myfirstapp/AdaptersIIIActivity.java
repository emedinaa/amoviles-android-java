package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.emedinaa.myfirstapp.adapters.ItemCheckAdapter;
import com.emedinaa.myfirstapp.model.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class AdaptersIIIActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ItemCheckAdapter itemCheckAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapters_03);
        enabledBack();
        recyclerView= findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        renderItems();
    }


    private void renderItems(){
        List<ItemEntity> itemEntityList= new ArrayList<>();
        itemEntityList.add(new ItemEntity("Item 1"));
        itemEntityList.add(new ItemEntity("Item 2"));
        itemEntityList.add(new ItemEntity("Item 3"));
        itemEntityList.add(new ItemEntity("Item 4"));
        itemEntityList.add(new ItemEntity("Item 5"));
        itemEntityList.add(new ItemEntity("Item 6"));
        itemEntityList.add(new ItemEntity("Item 7"));
        itemEntityList.add(new ItemEntity("Item 8"));
        itemEntityList.add(new ItemEntity("Item 9"));
        itemEntityList.add(new ItemEntity("Item 10"));
        itemEntityList.add(new ItemEntity("Item 11"));
        itemEntityList.add(new ItemEntity("Item 12"));
        itemEntityList.add(new ItemEntity("Item 13"));

        itemCheckAdapter= new ItemCheckAdapter(this,itemEntityList);
        recyclerView.setAdapter(itemCheckAdapter);
    }
}
