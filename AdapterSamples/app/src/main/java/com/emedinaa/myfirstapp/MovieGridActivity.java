package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.adapter.MovieGridAdapter;
import com.emedinaa.myfirstapp.data.Movies;
import com.emedinaa.myfirstapp.model.Movie;

import java.util.List;

public class MovieGridActivity extends BaseActivity {

    private GridView gridViewMovies;
    private MovieGridAdapter movieAdapter;
    private List<Movie> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_grid);
        enabledBack();
        gridViewMovies=findViewById(R.id.gridViewMovies);

        //data provider
        movies= Movies.getMovies();

        //Adapter
        MovieGridAdapter adapter= new MovieGridAdapter(this,movies);

        //set Adapter to UI
        gridViewMovies.setAdapter(adapter);


        //events
        gridViewMovies.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Movie movie =(Movie) adapterView.getAdapter().getItem(position);
                String message= movie.getTitle()+ " "+ movie.isCartelera();
                //String.format("title %s cartela %s ",movie.getTitle(),String.valueOf(movie.isCartelera()) );
                showItem(message);
            }
        });
    }

    private void showItem(String value) {
        Toast.makeText(this,"item "+value,Toast.LENGTH_SHORT).show();
    }
}
