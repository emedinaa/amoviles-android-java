package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Para asignar esta actividad como la primera en ejecutarse
   debes realizarlo en el archivo AndroidManifest.xml adicionando la etiqueta
   <intent-filter/>

   Por ejemplo
   <activity android:name=".MainActivity">
        <intent-filter>
            <action android:name="android.intent.action.MAIN" />
            <category android:name="android.intent.category.LAUNCHER" />
        </intent-filter>
   </activity>

   Solo puedes tener una actividad como 'LAUNCHER'
 */

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,
            textView9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1= findViewById(R.id.textView1);
        textView2= findViewById(R.id.textView2);
        textView3= findViewById(R.id.textView3);
        textView4= findViewById(R.id.textView4);
        textView5= findViewById(R.id.textView5);
        textView6= findViewById(R.id.textView6);
        textView7= findViewById(R.id.textView7);
        textView8= findViewById(R.id.textView8);
        textView9= findViewById(R.id.textView9);

        //events
        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);
        textView5.setOnClickListener(this);
        textView6.setOnClickListener(this);
        textView7.setOnClickListener(this);
        textView8.setOnClickListener(this);
        textView9.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.textView1:
                goToSimpleList();
                break;
            case R.id.textView2:
                goToSimpleGrid();
                break;
            case R.id.textView3:
                goToMovieList();
                break;
            case R.id.textView4:
                goToMovieGrid();
                break;
            case R.id.textView5:
                goToPokemonList();
                break;
            case R.id.textView6:
                goToPokemonAnimationList();
                break;
            case R.id.textView7:
                goToDynamicContent();
                break;
            case R.id.textView8:
                goToRecipes();
                break;
            case R.id.textView9:
                goToMultiple();
                break;
        }
    }

    private void goToSimpleList() {
        startActivity(new Intent(this,SimpleListActivity.class));
    }

    private void goToSimpleGrid() {
        startActivity(new Intent(this,SimpleGridActivity.class));
    }

    private void goToMovieList() {
        startActivity(new Intent(this,MovieListActivity.class));
    }

    private void goToMovieGrid() {
        startActivity(new Intent(this,MovieGridActivity.class));
    }

    private void goToPokemonList() {
        startActivity(new Intent(this,PokemonListActivity.class));
    }

    private void goToPokemonAnimationList() {
        startActivity(new Intent(this,PokemonAnimationListActivity.class));
    }

    private void goToDynamicContent() {
        startActivity(new Intent(this,DynamicContentActivity.class));
    }
    private void goToRecipes() {
        startActivity(new Intent(this,RecipeListActivity.class));
    }

    private void goToMultiple() {
        startActivity(new Intent(this,RecyclerMultipleActivity.class));
    }

    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.v("CONSOLE",message);
    }
}
