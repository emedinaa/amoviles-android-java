package com.emedinaa.myfirstapp;

import android.app.Application;

import com.emedinaa.myfirstapp.storage.CRUDOperations;
import com.emedinaa.myfirstapp.storage.MyDatabase;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/20/18
 */
public class NoteApplication extends Application {

    private CRUDOperations crudOperations;

    @Override
    public void onCreate() {
        super.onCreate();
        //storage options
        crudOperations= new CRUDOperations(new MyDatabase(this));
        DbInjector.setup(this);
    }

    public CRUDOperations getCrudOperations() {
        return crudOperations;
    }
}
