package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.adapter.SimpleGridAdapter;
import com.emedinaa.myfirstapp.data.Data;


public class SimpleGridActivity extends BaseActivity {

    /*
       1. Data Provider : List, ArrayList, Array
       2. View Container : ListView, GridView, RecyclerView
       3. Entity : Entity class
       4. Row : view Xml
       5. Adapter: ArrayAdapter , BaseAdapter, CursorAdapter
       6. Set Adapter to the View container

*/

    private GridView gridViewSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_grid);
        enabledBack();

        //1 Origen de datos Data.movies
        //2 Container gridViewSimple
        //3. Entity , String
        //4. Row row_simple_grid.xml
        //5. Adapter simpleGridAdapter

        gridViewSimple= findViewById(R.id.gridViewSimple);

        SimpleGridAdapter simpleGridAdapter= new SimpleGridAdapter(this,
                Data.movies);
        gridViewSimple.setAdapter(simpleGridAdapter);

        gridViewSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
