package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.emedinaa.myfirstapp.adapter.PokemonAnimationAdapter;
import com.emedinaa.myfirstapp.data.PokemonData;
import com.emedinaa.myfirstapp.interfaces.OnItemClickListener;
import com.emedinaa.myfirstapp.model.Pokemon;

import java.util.List;

public class PokemonAnimationListActivity extends BaseActivity implements OnItemClickListener {

    private final int DEFAULT_SPANCOUNT=3;
    private RecyclerView recyclerViewPokemon;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Pokemon> pokemonList;
    private PokemonAnimationAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        ui();

        loadPokemonData();
    }

    private void renderPokemons(){
        pokemonAdapter = new PokemonAnimationAdapter(this,this,pokemonList);
        recyclerViewPokemon.setAdapter(pokemonAdapter);
    }

    private void loadPokemonData() {
        pokemonList= new PokemonData().generate();
        renderPokemons();
    }

    private void ui() {
        enabledBack();

        recyclerViewPokemon= (RecyclerView)findViewById(R.id.recyclerViewPokemon);
        //mLayoutManager= new LinearLayoutManager(this);//,LinearLayoutManager.VERTICAL,)
        mLayoutManager = new GridLayoutManager(this,DEFAULT_SPANCOUNT);
        recyclerViewPokemon.setLayoutManager(mLayoutManager);

    }

    private void gotoDetailsAnimation(Pokemon pokemon,ImageView imageView){
        Intent intent= new Intent(this,PokemonDetailsActivity.class);
        intent.putExtra("POKEMON", pokemon);
        intent.putExtra("IMAGE_TRANSITION", ViewCompat.getTransitionName(imageView));

        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(
                this,
                imageView,
                ViewCompat.getTransitionName(imageView));

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            startActivity(intent,options.toBundle());
        }
    }

    //interface events

    @Override
    public void onClikListener(int position, View container, ImageView imageView) {
       if(pokemonList!=null){
                Pokemon pokemon= pokemonList.get(position);
                gotoDetailsAnimation(pokemon,imageView);
            }
    }
}
