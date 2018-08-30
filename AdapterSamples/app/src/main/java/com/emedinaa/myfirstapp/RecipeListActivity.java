package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.emedinaa.myfirstapp.adapter.RecipeAdapter;
import com.emedinaa.myfirstapp.data.RecipeData;
import com.emedinaa.myfirstapp.model.RecipeEntity;

import java.util.List;

public class RecipeListActivity extends BaseActivity {

    private ListView listViewRecipe;
    private List<RecipeEntity> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);
        enabledBack();
        ui();
        getRecipes();
    }

    private void getRecipes() {
        //origen de datos
        RecipeData recetaRepo= new RecipeData();
        recipes= recetaRepo.getRecipes();

        //adapter
        RecipeAdapter recetaAdapter= new RecipeAdapter(recipes,this);

        //setAdapter al view
        listViewRecipe.setAdapter(recetaAdapter);

    }
    private void ui() {
        listViewRecipe= (ListView) findViewById(R.id.listViewRecipe);
        //events
        listViewRecipe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int position, long l) {
                RecipeEntity receta= recipes.get(position);
                if(receta!=null){
                    goToRecipeDetails(receta);
                }
            }
        });
    }

    private void goToRecipeDetails(RecipeEntity receta) {
        Intent intent= new Intent(this,RecipeDetailsActivity.class);
        Bundle bundle= new Bundle();
        //bundle.putInt("ID",receta.getId());
        //bundle.putString("TITLE",receta.getTitle());
        bundle.putSerializable("RECETA",receta);
        intent.putExtras(bundle);
        //startActivity(intent);

        Log.v("CONSOLE","receta "+receta );
        Toast.makeText(this, "receta "+receta,
                Toast.LENGTH_SHORT).show();
    }
}
