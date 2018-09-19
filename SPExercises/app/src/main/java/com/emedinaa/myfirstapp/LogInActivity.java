package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.emedinaa.myfirstapp.storage.PreferencesHelper;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/18/18
 */
public class LogInActivity extends AppCompatActivity {
    private String username=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ui();
        checkSession();
    }

    private void checkSession(){
       if(PreferencesHelper.isSignedIn(this)){
           username=PreferencesHelper.getUserSession(this);
           ((EditText)(findViewById(R.id.editText))).setText(username);
       }else{
           username=null;
       }
    }
    private void ui(){
        findViewById(R.id.buttonLogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameTmp= ((EditText)(findViewById(R.id.editText))).getText().toString().trim();
                if(username!=null){
                    goToSPView();
                }else{
                    if(!usernameTmp.isEmpty()){
                        username= usernameTmp;
                        saveSession();
                        goToSPView();
                    }
                }
            }
        });
    }

    private void saveSession(){
        PreferencesHelper.saveSession(this, username);
    }

    private void goToSPView(){
        startActivity(new Intent(this, SharedPrefIActivity.class));
        finish();
    }
}
