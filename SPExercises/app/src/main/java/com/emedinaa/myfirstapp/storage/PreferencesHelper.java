
package com.emedinaa.myfirstapp.storage;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;


public class PreferencesHelper {

    private static final String MYNOTES_PREFERENCES = "com.amoviles.sharedpref";
    private static final String PREFERENCES_USERNAME = MYNOTES_PREFERENCES + ".username";
    private static final String PREFERENCES_PASSWORD = MYNOTES_PREFERENCES + ".password";
    private static final String PREFERENCES_COLOR = MYNOTES_PREFERENCES + ".color";
    private static final String PRODUCT_ID=MYNOTES_PREFERENCES+".productId";

    private PreferencesHelper() {
        //no instance
    }

    public static void signOut(final Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(PREFERENCES_USERNAME);
        editor.remove(PREFERENCES_PASSWORD);
        editor.apply();
    }

    public static void clearSession(final Context context){
        SharedPreferences.Editor editor = getEditor(context);
        editor.clear();
        editor.apply();
    }

    public static void saveSession(final Context context, String username)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_USERNAME, username);
        editor.apply();
    }

    public static String getUserSession(final Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String username= sharedPreferences.getString(PREFERENCES_USERNAME,null);
        return username;
    }

    public static void saveColor(String color,@NonNull final  Context context){
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_COLOR, color);
        editor.apply();
    }

    public static String getColor(final Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String color= sharedPreferences.getString(PREFERENCES_COLOR,null);
        return color;
    }

    public static boolean isSignedIn(final Context context) {
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.contains(PREFERENCES_USERNAME);
    }

    private static SharedPreferences.Editor getEditor(final Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(final Context context) {
        return context.getSharedPreferences(MYNOTES_PREFERENCES, Context.MODE_PRIVATE);
    }
}
