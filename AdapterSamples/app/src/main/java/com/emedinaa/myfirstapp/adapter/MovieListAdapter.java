package com.emedinaa.myfirstapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.model.Movie;

import java.util.List;

/**
 * @author Eduardo Medina
 */
public class MovieListAdapter extends BaseAdapter {

    private final Context context;
    private List<Movie> data;

    public MovieListAdapter(Context context, List<Movie> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(this.context).
                    inflate(R.layout.row_movie_list,parent,false);
        } else {
            view = convertView;
        }

        //elementos de la ui
        TextView tviTitle=(TextView)view.findViewById(R.id.tviName);
        ImageView iviCartelera= (ImageView)view.findViewById(R.id.iviCartelera);

        //entidad
        final Movie movie = data.get(position);

        //setear valores de la entidad en la celda
        tviTitle.setText(movie.getTitle());

        boolean cartelera= movie.isCartelera();
        if(cartelera){
            iviCartelera.setVisibility(View.VISIBLE);
        }else{
            iviCartelera.setVisibility(View.GONE);
        }

        if(position==0){
            tviTitle.setTextColor(Color.GREEN);
        }else{
            tviTitle.setTextColor(Color.BLACK);
        }

        return view;
    }
}
