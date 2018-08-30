package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
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

public class MainActivity extends AppCompatActivity {

    private int[] items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items= new int[]{R.id.textViewABasicI,R.id.textViewABasicII,R.id.textViewABasicIII,R.id.textViewABasicIV,R.id.textViewABasicV,
        R.id.textViewAdaptersI,R.id.textViewAdaptersII,R.id.textViewAdaptersIII,R.id.textViewAdaptersIV,R.id.textViewAdaptersV};

        for (final int itemViewId:items) {
            findViewById(itemViewId).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    goToView(itemViewId);
                }
            });
        }
    }

    private void goToView(int itemViewId){

        Class<?> itemClass=null;
        switch (itemViewId){
            case R.id.textViewABasicI:
                itemClass= AdapterBasicIActivity.class;
                break;

            case R.id.textViewABasicII:
                itemClass= AdapterBasicIIActivity.class;
                break;

            case R.id.textViewABasicIII:
                itemClass= AdapterBasicIIIActivity.class;
                break;

            case R.id.textViewABasicIV:
                itemClass= AdapterBasicIVActivity.class;
                break;

            case R.id.textViewABasicV:
                itemClass= AdapterBasicVActivity.class;
                break;

            case R.id.textViewAdaptersI:
                itemClass= AdaptersIActivity.class;
                break;

            case R.id.textViewAdaptersII:
                itemClass= AdaptersIIActivity.class;
                break;

            case R.id.textViewAdaptersIII:
                itemClass= AdaptersIIIActivity.class;
                break;

            case R.id.textViewAdaptersIV:
                itemClass= AdaptersIVActivity.class;
                break;

            case R.id.textViewAdaptersV:
                itemClass= AdaptersVActivity.class;
                break;
        }
        if(itemClass!=null){
            startActivity(new Intent(this,itemClass));
        }

    }

    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.v("CONSOLE",message);
    }
}
