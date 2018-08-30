package com.emedinaa.myfirstapp;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.emedinaa.myfirstapp.model.Pokemon;

import java.io.IOException;
import java.io.InputStream;

public class PokemonDetailsActivity extends BaseActivity {

    private Pokemon pokemon;
    private String imageTransitionName;

    private TextView textViewName;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_details);
        enabledBack();
        extras();
        ui();
        populate();
    }

    private void ui() {
        textViewName= (TextView)findViewById(R.id.textViewName);
        imageView= (ImageView) findViewById(R.id.imageView);
    }

    private void populate() {
        if(pokemon!=null){

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                imageView.setTransitionName(imageTransitionName);
            }

            imageView.setImageBitmap(getBitmapFromAssets(pokemon.getPhoto()));
            textViewName.setText(pokemon.getName());
        }
    }

    private void extras() {
        if(getIntent()!=null && getIntent().getExtras()!=null){
            pokemon= (Pokemon) getIntent().getExtras().getSerializable("POKEMON");
            imageTransitionName= getIntent().getExtras().getString("IMAGE_TRANSITION");
        }
    }

    public Bitmap getBitmapFromAssets(String fileName) {
        AssetManager assetManager = getAssets();

        InputStream istr = null;
        try {
            istr = assetManager.open(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bitmap = BitmapFactory.decodeStream(istr);

        return bitmap;
    }

}
