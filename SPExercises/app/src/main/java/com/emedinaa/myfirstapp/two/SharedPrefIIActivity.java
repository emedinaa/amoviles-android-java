package com.emedinaa.myfirstapp.two;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.emedinaa.myfirstapp.R;

public class SharedPrefIIActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private EditText editTextUsername;
    private Button buttonLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_pref_02);

        sharedPreferences= getSharedPreferences("spexercises",
                Context.MODE_PRIVATE);

        editTextUsername= findViewById(R.id.editTextUsername);
        buttonLogIn= findViewById(R.id.buttonLogIn);

        buttonLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextUsername.getText().toString().isEmpty()){
                    saveSession();
                    goToColorView();
                }
            }
        });

        if(checkSession()){
            goToColorView();
        }
    }
    private Boolean checkSession(){
        return sharedPreferences.contains("USERNAME");
        //String username= sharedPreferences.getString("USERNAME",null);
    }

    private void saveSession(){
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString("USERNAME",
                editTextUsername.getText().toString());
        editor.apply();
    }
    private void goToColorView()
    {
        startActivity(new Intent(this,ColorIIActivity.class));
    }
}
