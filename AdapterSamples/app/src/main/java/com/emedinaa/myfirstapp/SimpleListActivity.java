package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.adapter.SimpleListAdapter;


/*
       1. Data Provider : List, ArrayList, Array
       2. View Container : ListView, GridView, RecyclerView
       3. Entity : Entity class
       4. Row : view Xml
       5. Adapter: ArrayAdapter , BaseAdapter, CursorAdapter
       6. Set Adapter to the View container

*/

public class SimpleListActivity extends BaseActivity {

    private String[] mDays = {"Monday", "Tuesday","Wednesday","Thursday","Friday",
            "Saturday", "Sunday"};

    private String[] mMonths = {"January", "February","March","April","May",
            "June", "July", "August","September", "October", "November","December"};

    private ListView listViewSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_list);
        enabledBack();

        listViewSimple= findViewById(R.id.listViewSimple);
        //celda
        //android.R.layout.simple_list_item_1
        //R.layout.row_simple_list

        //adapter
        /*ArrayAdapter<String> myArrayAdapter= new ArrayAdapter<String>(this,
                R.layout.row_simple_list, mMonths);

        listViewSimple.setAdapter(myArrayAdapter);*/

        /*lviSimple.setAdapter(new ArrayAdapter<String>(this,
                R.layout.row_simple_list, mMonths));*/

        /*listViewSimple.setAdapter(new ArrayAdapter<String>(this,
                R.layout.row_simple_list, Data.movies));*/

        SimpleListAdapter mySimpleListAdapter= new SimpleListAdapter(this,
                mDays);
        listViewSimple.setAdapter(mySimpleListAdapter);

        //events
        listViewSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String value= String.valueOf(position)+" "+
                        String.valueOf(adapterView.getAdapter().getItem(position));
                showItem(value);
            }
        });
    }

    private void showItem(String value) {
        Toast.makeText(this,"item "+value,Toast.LENGTH_SHORT).show();
    }
}
