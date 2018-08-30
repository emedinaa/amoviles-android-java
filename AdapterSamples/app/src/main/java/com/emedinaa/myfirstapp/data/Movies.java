package com.emedinaa.myfirstapp.data;


import com.emedinaa.myfirstapp.model.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 2/20/18.
 */

public class Movies {

    public static  List<Movie> getMovies(){

        List<Movie> movieList= new ArrayList<>();
        movieList.add(new Movie("Batman",false));
        movieList.add(new Movie("Tiburón",false));
        movieList.add(new Movie("Harry Potter",true));
        movieList.add(new Movie("LA REINA DE KATWE",false));
        movieList.add(new Movie("ROBERT EL MUNECO POSEIDO",true));
        movieList.add(new Movie("UNA PAREJA DISPAREJA",false));
        movieList.add(new Movie("ROBERT EL MUNECO POSEIDO",true));
        movieList.add(new Movie("ENEMIGO EN LA RED",true));
        movieList.add(new Movie("ROBERT EL MUNECO POSEIDO",true));
        movieList.add(new Movie("LA REINA DE KATWE",true));

        return movieList;
    }
}
