package com.emedinaa.myfirstapp.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 10/4/18
 */
public class CustomIntentService extends IntentService {

    public CustomIntentService() {
        super("CustomIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        String value = intent.getStringExtra("VALUE");

        Log.v("CONSOLE", "onHandleIntent "+value);
        intent.setAction("INTENT_ACTION");
        SystemClock.sleep(3000);
        String serviceMessage = "IntentService";
        LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent.putExtra("MESSAGE", serviceMessage));
    }
}
