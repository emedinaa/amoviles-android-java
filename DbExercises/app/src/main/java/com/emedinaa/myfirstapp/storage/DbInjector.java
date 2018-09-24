package com.emedinaa.myfirstapp.storage;

import android.content.Context;

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
