package maraudersmap.takenet.com.br.maraudersmap.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.Map;


public final class SharedPreferencesHelper {


    public static final String TAG = "SharedPreferencesHelper";

    public static Map<String, ?> readAll(Context context, String file) {
        Map<String, ?> prefs = null;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            prefs = sharedPrefs.getAll();
        } catch (Exception e) {
            prefs = null;
            Log.e(TAG, e.getMessage(), e);
        }

        return prefs;
    }

    public static boolean read(Context context, String file, String key,
                               boolean defaultValue) {
        boolean value = false;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            value = sharedPrefs.getBoolean(key, defaultValue);
        } catch (Exception e) {
            value = defaultValue;
            Log.e(TAG, e.getMessage(), e);
        }

        return value;
    }

    public static String read(Context context, String file, String key,
                              String defaultValue) {
        String value = null;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            value = sharedPrefs.getString(key, defaultValue);
        } catch (Exception e) {
            value = defaultValue;
            Log.e(TAG, e.getMessage(), e);
        }

        return value;
    }

    public static long read(Context context, String file, String key, long defaultValue) {
        long value = Long.MIN_VALUE;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            value = sharedPrefs.getLong(key, defaultValue);
        } catch (Exception e) {
            value = defaultValue;
            Log.e(TAG, e.getMessage(), e);
        }

        return value;
    }

    public static boolean write(Context context, String file, String key, boolean value) {
        boolean sucess = false;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putBoolean(key, value);
            editor.commit();
            sucess = true;
        } catch (Exception e) {
            sucess = false;
            Log.e(TAG, e.getMessage(), e);
        }

        return sucess;
    }

    public static boolean write(Context context, String file, String key, String value) {
        boolean sucess = false;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putString(key, value);
            editor.commit();
            sucess = true;
        } catch (Exception e) {
            sucess = false;
            Log.e(TAG, e.getMessage(), e);
        }

        return sucess;
    }

    public static boolean write(Context context, String file, String key, long value) {
        boolean sucess = false;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putLong(key, value);
            editor.commit();
            sucess = true;
        } catch (Exception e) {
            sucess = false;
            Log.e(TAG, e.getMessage(), e);
        }

        return sucess;
    }



    public static boolean remove(Context context, String file, String key) {
        boolean sucess = false;
        try {
            SharedPreferences sharedPrefs = context.getSharedPreferences(file, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.remove(key);
            editor.commit();
            sucess = true;
        } catch (Exception e) {
            sucess = false;
            Log.e(TAG, e.getMessage(), e);
        }

        return sucess;
    }

}
