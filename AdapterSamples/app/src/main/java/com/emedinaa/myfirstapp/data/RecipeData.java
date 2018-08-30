package com.emedinaa.myfirstapp.data;


import com.emedinaa.myfirstapp.model.RecipeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 27/01/17.
 */

public class RecipeData {

    private List<RecipeEntity> recipeList;

    public RecipeData() {

        recipeList= new ArrayList<>();
        recipeList.add(new RecipeEntity(100,"Adobo de chancho",
                "El adobo es un estilo de preparación proveniente de Europa; pero en Perú..",
                true));

        recipeList.add(new RecipeEntity(101,"Aguadito",
                "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre..",
                false));

        recipeList.add(new RecipeEntity(102,"Ajiaco de papas",
                "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
                true));

        recipeList.add(new RecipeEntity(103,"Ají de gallina",
                "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
                true));

        recipeList.add(new RecipeEntity(104,"Ajiaco de papas",
                "El ajiaco es un plato sudamericano, se prepara en Chile, Colombia, Argentina..",
                false));

        recipeList.add(new RecipeEntity(105,"Aguadito",
                "Otro platillo de larga data, una sopa espesa contradictoriamente a su nombre,"));

        recipeList.add(new RecipeEntity(106,"Adobo de chancho",
                "El adobo es un estilo de preparación proveniente de Europa; pero en Perú",
                true));
    }

    public List<RecipeEntity> getRecipes() {
        return recipeList;
    }
}
