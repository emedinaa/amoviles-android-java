package com.emedinaa.myfirstapp.data;

import com.emedinaa.myfirstapp.model.MovieEntity;
import com.emedinaa.myfirstapp.model.PlaceEntity;
import com.emedinaa.myfirstapp.model.TypeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 27/01/17.
 */

public class MultipleData {

    private List<TypeEntity>  objects;

    public MultipleData() {
        objects= new ArrayList<>();
        objects.add(new PlaceEntity(0,"Alcazar"));
        objects.add(new MovieEntity("Batman",true));
        objects.add(new MovieEntity("ROBERT EL MUNECO POSEIDO",true));
        objects.add(new MovieEntity("ENEMIGO EN LA RED",true));
        objects.add(new PlaceEntity(1,"Brasil"));
        objects.add(new MovieEntity("LA REINA DE KATWE",false));
        objects.add(new PlaceEntity(2,"Centro Cívico"));
        objects.add(new MovieEntity("Tiburón",false));
        objects.add(new PlaceEntity(2,"Comas"));
        objects.add(new MovieEntity("Harry Potter",true));
        objects.add(new MovieEntity("UNA PAREJA DISPAREJA",true));
    }

    public List<TypeEntity> getObjects() {
        return objects;
    }


}
