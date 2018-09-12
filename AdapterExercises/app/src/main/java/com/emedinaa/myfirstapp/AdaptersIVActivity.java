package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.emedinaa.myfirstapp.adapters.ItemAdapter;
import com.emedinaa.myfirstapp.model.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class AdaptersIVActivity extends BaseActivity {

    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapters_04);
        enabledBack();
        recyclerView= findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        renderItems();
    }

    private void renderItems(){
        List<ItemEntity> itemEntityList= new ArrayList<>();
        itemEntityList.add(new ItemEntity("Item 1",false));
        itemEntityList.add(new ItemEntity("Item 2",true));
        itemEntityList.add(new ItemEntity("Item 3",false));
        itemEntityList.add(new ItemEntity("Item 4",true));
        itemEntityList.add(new ItemEntity("Item 5",false));
        itemEntityList.add(new ItemEntity("Item 6",false));
        itemEntityList.add(new ItemEntity("Item 7",false));
        itemEntityList.add(new ItemEntity("Item 8",false));
        itemEntityList.add(new ItemEntity("Item 9",false));
        itemEntityList.add(new ItemEntity("Item 10",false));
        itemEntityList.add(new ItemEntity("Item 11",false));
        itemEntityList.add(new ItemEntity("Item 12",false));
        itemEntityList.add(new ItemEntity("Item 13",false));

        itemAdapter= new ItemAdapter(this,itemEntityList);
        recyclerView.setAdapter(itemAdapter);
    }
}
