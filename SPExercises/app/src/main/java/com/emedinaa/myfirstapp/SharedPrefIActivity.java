package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.emedinaa.myfirstapp.storage.PreferencesHelper;

public class SharedPrefIActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button,button2,button3,button4;
    private Button button5,button6;

    private String currentColor=null;
    //private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_01);

        /*sharedPreferences= getSharedPreferences(
                "com.amoviles.spexercises",
                Context.MODE_PRIVATE);*/
        ui();
        checkColor();
    }

    private void checkColor(){
        //currentColor= sharedPreferences.getString("COLOR",null);
        currentColor= PreferencesHelper.getColor(this);
        if(currentColor!=null){
            int colorValue= Color.parseColor(currentColor);
            findViewById(R.id.frameLayout).setBackgroundColor(colorValue);
        }
    }

    private void ui() {
        button= findViewById(R.id.button);
        button2= findViewById(R.id.button2);
        button3= findViewById(R.id.button3);
        button4= findViewById(R.id.button4);

        button5= findViewById(R.id.button5);
        button6= findViewById(R.id.button6);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);

        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button://black
                    selectedColor("#000000");
                break;

            case R.id.button2://red
                    selectedColor("#FF0000");
                break;

            case R.id.button3://blue
                    selectedColor("#2ECCFA");
                break;

            case R.id.button4://green
                    selectedColor("#00FF00");
                break;

            case R.id.button5:
                save();
                break;
            case R.id.button6:
                reset();
                goToLogIn();
                break;
        }
    }

    private void selectedColor(String color){
        currentColor=color;
        int colorValue= Color.parseColor(color);
        findViewById(R.id.frameLayout).setBackgroundColor(colorValue);

        /*Toast.makeText(this,"currenColor "+currentColor,
                Toast.LENGTH_SHORT).show();*/
    }

    private void save(){
        if(currentColor==null)return;
        /*SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("COLOR", currentColor);
        editor.apply();*/
        PreferencesHelper.saveColor(currentColor,this);

        Toast.makeText(this,"Saved color "+currentColor,
                Toast.LENGTH_SHORT).show();
    }

    private void reset(){
        currentColor=null;
        int colorValue= Color.parseColor("#d4d4d4");
        findViewById(R.id.frameLayout).setBackgroundColor(colorValue);
        /*SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        //editor.remove("COLOR");
        editor.apply();*/
        PreferencesHelper.clearSession(this);
    }

    private void goToLogIn(){
        startActivity(new Intent(this,LogInActivity.class));
        finish();
    }
}
