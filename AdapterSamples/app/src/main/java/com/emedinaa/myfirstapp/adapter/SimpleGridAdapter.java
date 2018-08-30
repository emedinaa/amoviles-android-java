package com.emedinaa.myfirstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;


/**
 * Created by emedinaa on 15/10/15.
 */
public class SimpleGridAdapter extends BaseAdapter {

    private Context context;
    private String[] data;

    public SimpleGridAdapter(Context context, String[] data) {
        this.context=context;
        this.data= data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(this.context).inflate(R.layout.row_simple_grid,parent,false);
        } else {
            view = convertView;
        }
        TextView  tviTitle=view.findViewById(R.id.tviTitle);
        tviTitle.setText(data[position]);
        return view;
    }
}
