package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.emedinaa.myfirstapp.adapter.PokemonAdapter;
import com.emedinaa.myfirstapp.data.PokemonData;
import com.emedinaa.myfirstapp.events.ClickListener;
import com.emedinaa.myfirstapp.events.RecyclerTouchListener;
import com.emedinaa.myfirstapp.model.Pokemon;

import java.util.List;

public class PokemonListActivity extends BaseActivity  {

    /**
     * 1. Origen de datos : PokemonData
     * 2. Entidad :Pokemon
     * 3. Row : row_pokemon
     * 4. Container : recyclerViewPokemon
     * 5. Adapter : PokemonAdapter
     * 6. Setear adapter al recycler
     */
    private final int DEFAULT_SPANCOUNT=3;
    private RecyclerView recyclerViewPokemon;
    private RecyclerView.LayoutManager mLayoutManager;

    private List<Pokemon> pokemonList;
    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);
        ui();

        loadPokemonData();
    }

    private void renderPokemons(){
        pokemonAdapter = new PokemonAdapter(this,pokemonList);
        //pokemonAdapter.setOnItemClickListener(this);

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

        //events
        recyclerViewPokemon.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewPokemon, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(pokemonList!=null){
                    Pokemon pokemon= pokemonList.get(position);
                    Toast.makeText(PokemonListActivity.this, "pokemon "+pokemon,
                            Toast.LENGTH_SHORT).show();
                    goToDetails(pokemon);
                }
            }

            @Override
            public void onLongClick(View view, int position) {}
        }));
    }

    private void goToDetails(Pokemon pokemon){
        Intent intent= new Intent(this,PokemonDetailsActivity.class);
        startActivity(intent);
    }

}
