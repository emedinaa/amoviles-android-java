package com.emedinaa.myfirstapp;

import android.content.Context;

import com.emedinaa.myfirstapp.storage.CRUDOperations;
import com.emedinaa.myfirstapp.storage.MyDatabase;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/20/18
 */
public class DbInjector {

    private static CRUDOperations crudOperations;

    public static void  setup(final Context context){
        crudOperations= new CRUDOperations(new MyDatabase(context));
    }

    public static CRUDOperations db(){
        return crudOperations;
    }
}
