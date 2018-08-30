package com.emedinaa.myfirstapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 5/28/18
 */
public class SimpleAListAdapter extends ArrayAdapter<String> {

    public SimpleAListAdapter(@NonNull Context context, int resource, @NonNull String[] objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return super.getView(position, convertView, parent);
    }
}
