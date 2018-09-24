
package com.emedinaa.myfirstapp.storage.preferences;
import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesHelper {

    private static final String MYNOTES_PREFERENCES = "mynotesPreferences";
    private static final String PREFERENCES_USERNAME = MYNOTES_PREFERENCES + ".username";
    private static final String PREFERENCES_PASSWORD = MYNOTES_PREFERENCES + ".password";
    private static final String PREFERENCES_TOKEN = MYNOTES_PREFERENCES + ".token";

    public PreferencesHelper() {
        //no instance
    }

    public static void signOut(Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(PREFERENCES_USERNAME);
        editor.remove(PREFERENCES_PASSWORD);
        editor.apply();
    }

    public static void saveSession(Context context,String username,String password)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_USERNAME, username);
        editor.putString(PREFERENCES_PASSWORD, password);
        editor.apply();
    }

    public static void saveBLSession(Context context,String username,String token)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_USERNAME, username);
        editor.putString(PREFERENCES_TOKEN, token);
        editor.apply();
    }

    public static String getUserSession(Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String username= sharedPreferences.getString(PREFERENCES_USERNAME,null);

        return username;
    }

    public  String getUserTokenSession(Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String token= sharedPreferences.getString(PREFERENCES_TOKEN,null);

        return token;
    }

    public static String getTokenSession(Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String token= sharedPreferences.getString(PREFERENCES_TOKEN,null);

        return token;
    }

    public static boolean isSignedIn(Context context) {
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.contains(PREFERENCES_USERNAME);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(MYNOTES_PREFERENCES, Context.MODE_PRIVATE);
    }
}
