package com.emedinaa.myfirstapp;

import android.app.Application;

import com.emedinaa.myfirstapp.storage.DbInjector;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/20/18
 */
public class NoteApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DbInjector.setup(this);
    }
}
