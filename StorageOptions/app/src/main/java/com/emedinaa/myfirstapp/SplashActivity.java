package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.emedinaa.myfirstapp.storage.PreferencesHelper;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private static final long SPLASH_SCREEN_DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        app();
    }

    private void app() {

        TimerTask task = new TimerTask()
        {
            @Override
            public void run() {
                Intent intent;
                /*SharedPreferences sharedPreferences=getSharedPreferences("DEMO", Context.MODE_PRIVATE);
                String username =sharedPreferences.getString("USERNAME",null);
                String password =sharedPreferences.getString("PASSWORD",null);
                if(username==null || password==null){
                    //go To Login
                }else{
                    //go To Dashboard
                }*/
                boolean session= PreferencesHelper.isSignedIn(SplashActivity.this);
                if(session)
                {
                    intent=new Intent(SplashActivity.this, DashboardActivity.class);
                }else {
                    intent = new Intent(SplashActivity.this, LogInActivity.class);
                }
                startActivity(intent);
                finish();
            }
        };

        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

}
