package com.emedinaa.myfirstapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class BatteryLevelBroadcastReceiver extends BroadcastReceiver{

    private BatteryLevelCallback callback=null;
    @Override
    public void onReceive(final Context context, Intent intent) {
        int level = intent.getIntExtra("level", 0);

        Log.v("CONSOLE","level "+level);
        if(callback!=null){
            callback.onLevel(level);
        }
    }

    public void registerCallback(BatteryLevelCallback callback){
        this.callback= callback;
    }

    public void unRegisterCallback(){
        this.callback=null;
    }

    interface BatteryLevelCallback{
        void onLevel(int level);
    }
}
