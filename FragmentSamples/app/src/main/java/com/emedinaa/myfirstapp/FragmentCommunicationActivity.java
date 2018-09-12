package com.emedinaa.myfirstapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.emedinaa.myfirstapp.ui.fragments.BlankFragment;
import com.emedinaa.myfirstapp.ui.fragments.BlankFragmentListener;


public class FragmentCommunicationActivity extends AppCompatActivity
implements BlankFragmentListener {

    private BlankFragment blankFragment;
    private FragmentManager fragmentManager;
    private View constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        constraintLayout= findViewById(R.id.constraintLayout);

        fragmentManager= getSupportFragmentManager();
        blankFragment= (BlankFragment)fragmentManager.findFragmentById(R.id.blankFragment);

        //blankFragment.ejecutarAccionDesdeFragment("Hola Fragment lanzado por el activity");

        //blankFragment.cambiarColorFondo();
    }

    public static void otroSuperMetodo(){
        Log.v("CONSOLE","Hello Activity, lanzado desde fragment");
    }

    public void otroMetodo(){
        Toast.makeText(this,"Hello Activity, lanzado desde fragment",Toast.LENGTH_LONG).show();
    }

    @Override
    public void actionFragment(Object object) {
        String message= String.valueOf(object);
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void actionActivityCambiarColor() {
        constraintLayout.setBackgroundColor(Color.YELLOW);
    }

    @Override
    public void callToActivity(Object object) {

    }

    @Override
    public void cerrarSesion() {

    }

    @Override
    public void loQueYoQuiera() {
        Toast.makeText(this,"Hello Activity, lanzado desde fragment",Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
