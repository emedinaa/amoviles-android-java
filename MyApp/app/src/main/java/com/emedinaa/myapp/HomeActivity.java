package com.emedinaa.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    private Button button;
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        button= findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                action();
            }
        });

    }

    private void action(){
        Log.d("CONSOLE","action");

        Log.d("CONSOLE","message "+message);
        String aux= message;

        int size= message.length();

        Log.d("CONSOLE","size "+size );
    }
}
