package com.emedinaa.myfirstapp.utils;

import android.support.annotation.NonNull;
import android.util.Log;

import com.emedinaa.myfirstapp.BuildConfig;

public class NLog {
    private static final String TAG="CONSOLE";

    public static void v(@NonNull String message){
        if(BuildConfig.DEBUG){
            Log.v(TAG,message);
        }
    }
}
