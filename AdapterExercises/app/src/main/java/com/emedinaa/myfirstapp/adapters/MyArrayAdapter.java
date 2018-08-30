package com.emedinaa.myfirstapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by eduardomedina on 20/02/18.
 */

public class MyArrayAdapter extends ArrayAdapter {

    public MyArrayAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
}
