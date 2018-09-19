package com.emedinaa.myfirstapp.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/18/18
 */
public class SOSharedPreferences implements MySharedPreferences {
    private  final String MYNOTES_PREFERENCES = "com.amoviles.sp";
    private  final String PREFERENCES_USERNAME = MYNOTES_PREFERENCES + ".username";
    private  final String PREFERENCES_PASSWORD = MYNOTES_PREFERENCES + ".password";
    private  final String PRODUCT_ID=MYNOTES_PREFERENCES+".productId";

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor spEditor;

    @Override
    public void setup(@NonNull Context context) {
       sharedPreferences=context.getSharedPreferences(MYNOTES_PREFERENCES, Context.MODE_PRIVATE);
       spEditor= sharedPreferences.edit();
    }

    @Override
    public void saveSession(String username, String password) {
        spEditor.putString(PREFERENCES_USERNAME, username);
        spEditor.putString(PREFERENCES_PASSWORD, password);
        spEditor.apply();
    }

    @Override
    public void signOut() {
        spEditor.remove(PREFERENCES_USERNAME);
        spEditor.remove(PREFERENCES_PASSWORD);
        //spEditor.clear();
        spEditor.apply();
    }

    @Override
    public boolean isSignedIn() {
        return sharedPreferences.contains(PREFERENCES_USERNAME) &&
                sharedPreferences.contains(PREFERENCES_PASSWORD);
    }
}
