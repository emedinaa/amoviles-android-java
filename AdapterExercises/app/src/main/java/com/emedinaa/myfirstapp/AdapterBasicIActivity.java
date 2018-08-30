package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.widget.ListView;

import com.emedinaa.myfirstapp.adapters.SimpleListAdapter;


public class AdapterBasicIActivity extends BaseActivity {

    private String[] items={"Item1","Item2","Item3",
    "Item 4", "Item 5", "Item 6", "Item 7"};

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_basic_01);
        enabledBack();

        listView= findViewById(R.id.listView);

        /*ArrayAdapter<String> arrayAdapter=
                new ArrayAdapter<String>(this,
                        R.layout.row_simple_list, items);*/
        SimpleListAdapter simpleListAdapter= new
                SimpleListAdapter(this,items);
        listView.setAdapter(simpleListAdapter);
    }
}
