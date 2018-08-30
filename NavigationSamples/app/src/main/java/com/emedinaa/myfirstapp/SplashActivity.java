package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private final int SPLASH_TIME=3000;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        timer= new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                goToLogIn();
            }
        };

        timer.schedule(task, SPLASH_TIME);

    }

    private void goToLogIn(){
        Intent intent= new Intent(this,LogInActivity.class);

        startActivity(intent);
        finish();
    }

    /*private void goToLogIn(){
        //1. En que pantalla estoy
        //2. A que pantalla quiero ir
        //3. Voy a regresar, la vista se destruye
        String[] arr= {"L","M","M"};
        Bundle bundle= new Bundle();
        bundle.putInt("USERID",10);
        bundle.putString("USERNAME","Eduardo");
        bundle.putStringArray("ARR",arr);
        bundle.putSerializable("OBJSR",new MyEntity());
        bundle.putParcelable("OBJPR",null);

        Intent intent= new Intent(this,LogInActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
        finish();
    }*/
}
