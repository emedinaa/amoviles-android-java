package com.emedinaa.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /**
     * Para asignar esta actividad como la primera en ejecutarse
     debes realizarlo en el archivo AndroidManifest.xml adicionando la etiqueta
     <intent-filter/>
     Por ejemplo
     <activity android:name=".MainActivity">
     <intent-filter>
     <action android:name="android.intent.action.MAIN" />
     <category android:name="android.intent.category.LAUNCHER" />
     </intent-filter>
     </activity>
     Solo puedes tener una actividad como 'LAUNCHER'
     */

    private final String USER_MESSAGE="This is my First Android App";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= findViewById(R.id.textView);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMessage(USER_MESSAGE);
            }
        });

        //BuildConfig.HOST
        //BuildConfig.GA
    }

    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.v("CONSOLE",message);
    }
}
