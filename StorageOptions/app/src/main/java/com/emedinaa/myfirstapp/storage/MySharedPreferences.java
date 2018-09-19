package com.emedinaa.myfirstapp.storage;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 9/18/18
 */
public interface MySharedPreferences {

    void setup(@NonNull final Context context);
    void saveSession(String username, String password);
    void signOut();
    boolean isSignedIn();
}
