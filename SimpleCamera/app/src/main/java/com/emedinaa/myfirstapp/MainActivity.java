package com.emedinaa.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity
implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.textView1).setOnClickListener(this);
        findViewById(R.id.textView2).setOnClickListener(this);
        findViewById(R.id.textView3).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case  R.id.textView1:
                    goToCameraIntent();
                break;
            case  R.id.textView2:
                    goToCameraIntentBase();
                break;
            case  R.id.textView3:
                    goToCustomCamera();
                break;
        }
    }

    private void goToCameraIntent() {
        startActivity(new Intent(this,CameraIntentActivity.class));
    }

    private void goToCameraIntentBase() {
        startActivity(new Intent(this,CameraIntentBaseActivity.class));
    }

    private void goToCustomCamera() {
        startActivity(new Intent(this,CustomCameraActivity.class));
    }

}
