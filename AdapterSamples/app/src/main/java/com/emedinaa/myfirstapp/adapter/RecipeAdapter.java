package com.emedinaa.myfirstapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.interfaces.RecipeHandler;
import com.emedinaa.myfirstapp.model.RecipeEntity;

import java.util.List;

/**
 * Created by eduardomedina on 21/02/18.
 */

public class RecipeAdapter extends BaseAdapter{

    private List<RecipeEntity> recetas;
    private final Context context;
    private RecipeHandler listener;

    public RecipeAdapter(List<RecipeEntity> recetas, Context context) {
        this.recetas = recetas;
        this.context = context;
        //this.listener= (RecipeHandler) (context);
    }

    public RecipeAdapter(List<RecipeEntity> recetas, Context context, RecipeHandler recipeHandler) {
        this.recetas = recetas;
        this.context = context;
        this.listener= recipeHandler;
    }

    @Override
    public int getCount() {
        return recetas.size();
    }

    @Override
    public Object getItem(int position) {
        return recetas.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        View view;
        if(convertView==null){
            view= LayoutInflater.from(context).
                    inflate(R.layout.row_recipe,viewGroup,false);
        }else{
            view= convertView;
        }

        TextView tviTitle= (TextView)
                view.findViewById(R.id.tviTitle);

        TextView tviDesc= (TextView)
                view.findViewById(R.id.tviDesc);

        View iviFavorite= view.findViewById(R.id.iviFavorite);

        //render asociar entidad con el row
        final RecipeEntity receta= recetas.get(position);
        if(receta!=null){
            tviTitle.setText(checkNotNull(receta.getTitle()));
            tviDesc.setText(checkNotNull(receta.getDesc()));
            if(receta.isFavorite()){
                iviFavorite.setVisibility(View.VISIBLE);
            }else{
                iviFavorite.setVisibility(View.GONE);
            }
        }
        //events
        /*view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //goToRecipeDetails(receta);
                if(listener!=null){
                    listener.selectedRecipe(receta);
                }
            }
        });*/
        iviFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener!=null){
                    listener.selectedRecipe(receta);
                }
            }
        });
        return  view;
    }

   /* private void goToRecipeDetails(RecipeEntity recipeEntity){
        Toast.makeText(context, "Adapter - receta "+recipeEntity,
                Toast.LENGTH_SHORT).show();
    }*/

    private String checkNotNull(String value){
        String string ;
        if(value==null || value.isEmpty()){
            string="";
        }else{
            string= value;
        }
        return  string;
    }
}
