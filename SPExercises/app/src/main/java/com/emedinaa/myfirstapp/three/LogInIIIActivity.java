package com.emedinaa.myfirstapp.three;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.emedinaa.myfirstapp.R;
import com.emedinaa.myfirstapp.SharedPrefIVActivity;
import com.emedinaa.myfirstapp.storage.PreferencesHelper;

public class LogInIIIActivity extends AppCompatActivity {

    private String username=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_03);
        ui();
    }

    private void ui(){
        findViewById(R.id.buttonLogIn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username= ((EditText)(findViewById(R.id.editText))).getText().toString().trim();
                if(!username.isEmpty()){
                    saveSession();
                    goToSPView();
                }
            }
        });
    }

    private void saveSession(){
        PreferencesHelper.saveSession(this, username);
    }

    private void goToSPView(){
        startActivity(new Intent(this, SharedPrefIVActivity.class));
    }
}
