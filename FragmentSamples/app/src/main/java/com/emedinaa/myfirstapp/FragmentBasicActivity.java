package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.emedinaa.myfirstapp.ui.fragments.BlankFragment;
import com.emedinaa.myfirstapp.ui.fragments.BlankFragmentListener;


public class FragmentBasicActivity extends AppCompatActivity
implements BlankFragmentListener {

    private BlankFragment blankFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_basic);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        fragmentManager= getSupportFragmentManager();
        blankFragment= (BlankFragment) fragmentManager.findFragmentById(R.id.blankFragment);

        Log.v("CONSOLE", "(2) 1 Desde FragmentBasicActivity");
        blankFragment.cambiarColorFondo();
        //blankFragment.getView().findViewById(R.id.textViewMessage)

        //blankFragment.ejecutarAccionDesdeFragment("Hola Fragment");
        //blankFragment.cambiarColorFondo();

    }

    @Override
    public void actionFragment(Object object) {
       //TODO REALIZAR ACCION
    }

    @Override
    public void actionActivityCambiarColor() {

    }

    @Override
    public void callToActivity(Object object) {
        Log.v("CONSOLE", "3. Recibe en FragmentBasicActivity");
        Toast.makeText(this,"Hola desde Fragment !",
                Toast.LENGTH_LONG).show();
    }


    @Override
    public void cerrarSesion() {

    }

    @Override
    public void loQueYoQuiera() {

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    //NO HACER...
    public static void llamarAPapa(){

    }

    public  void llamarAPapa2(){
        Log.v("CONSOLE", "llamar a Papa 2");
    }
}
