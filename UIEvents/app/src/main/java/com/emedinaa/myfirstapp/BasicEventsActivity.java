package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class BasicEventsActivity extends BaseActivity
implements View.OnClickListener{

    private  Button btn;
    private ImageView ivi;
    private  FrameLayout flay;
    private TextView tvi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_events);
        ui();
    }

    private void ui() {

        btn= findViewById(R.id.btn);
        ivi=  findViewById(R.id.ivi);
        flay=  findViewById(R.id.flay);
        tvi= findViewById(R.id.tvi);

        /*btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        btn.setOnClickListener(this);
        ivi.setOnClickListener(this);
        flay.setOnClickListener(this);
        tvi.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        String message= null;
        switch (v.getId()){
            case R.id.btn:
                    message= "BUTTON";
                break;
            case R.id.ivi:
                    message= "IMAGEVIEW";
                break;
            case R.id.flay:
                    message= "FRAMELAYOUT";
                break;
            case R.id.tvi:
                    message= "TEXTVIEW";
                break;
        }

        if(message!=null)
            showMessage(message);
    }

    private void showMessage(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }



}
