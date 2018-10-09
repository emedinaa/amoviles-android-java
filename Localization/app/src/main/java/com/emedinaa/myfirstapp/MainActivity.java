package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     *
     * https://developer.android.com/static/images/kotlin/hero.svg
     * https://developer.android.com/static/images/kotlin/features/modern-expressive.svg
     * https://developer.android.com/static/images/kotlin/features/safer-code.svg
     * https://developer.android.com/static/images/kotlin/features/interoperable.gif
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.v("CONSOLE",message);
    }
}
