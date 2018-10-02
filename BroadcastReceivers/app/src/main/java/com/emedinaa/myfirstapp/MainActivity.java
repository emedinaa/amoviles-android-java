package com.emedinaa.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements BatteryLevelBroadcastReceiver.BatteryLevelCallback {

    /**
     * Broadcast Receivers
     * 1. Registrar broadcast receiver en AndroidManifest
     * 2. Declarar broadcast customizado o usar uno por default
     * 3. Invocarlo en el activity o fragment.
     *
     * https://developer.android.com/reference/android/content/Intent
     * Intent.ACTION_BATTERY_CHANGED
     * Intent.ACTION_BOOT_COMPLETED
     * Intent.ACTION_POWER_CONNECTED
     * Intent.ACTION_POWER_DISCONNECTED
     * Intent.ACTION_BATTERY_LOW
     * Intent.ACTION_BATTERY_OKAY
     */

    //private BroadcastReceiver batteryLevelReceiver;
    private BatteryLevelBroadcastReceiver batteryLevelReceiver;
    private FrameLayout frameLayoutContainer;
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frameLayoutContainer= findViewById(R.id.frameLayoutContainer);
        myView= new MyView(this);
        myView.setBackgroundColor(Color.WHITE);
        FrameLayout.LayoutParams layoutParams= new FrameLayout.LayoutParams( FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.MATCH_PARENT );
        layoutParams.gravity= Gravity.CENTER;
        myView.setLayoutParams(layoutParams);
        frameLayoutContainer.addView(myView);

        batteryLevelReceiver= new BatteryLevelBroadcastReceiver();
    }


    @Override
    protected void onStop() {
        if (batteryLevelReceiver != null) {
            batteryLevelReceiver.unRegisterCallback();
            unregisterReceiver(batteryLevelReceiver);
        }
        super.onStop();
    }

    @Override
    protected void onStart() {
        IntentFilter intentFilter= new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(batteryLevelReceiver,intentFilter);
        batteryLevelReceiver.registerCallback(this);
        super.onStart();
    }

    @Override
    public void onLevel(int level) {
        showMessage("Level "+level);
        myView.updateView(level);
    }

    private void showMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        Log.v("CONSOLE",message);
    }
}
