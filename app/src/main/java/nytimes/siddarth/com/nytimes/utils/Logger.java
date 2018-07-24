package nytimes.siddarth.com.nytimes.utils;

import android.util.Log;

import nytimes.siddarth.com.nytimes.BuildConfig;

public class Logger {

    private static final String TAG = "NyTimes";


    private Logger(){

    }


    /**
     *
     *
     * Log app error.
     *
     * @param message Error message.
     * @param error   Error object.
     */
    public static void logError(String message, Throwable error) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, message, error);
        }

    }

    /**
     *
     *
     * Log app error.
     *
     * @param error   Error object.
     */
    public static void logError(Throwable error) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, error.getMessage(), error);
        }
    }

    /**
     * Log app error.
     *
     * @param message Error message.
     */
    public static void logError(String message) {
        if (BuildConfig.DEBUG) {
            Log.e(TAG, message);
        }
    }

    /**
     * Log an info message.
     *
     * @param message info message.
     */
    public static void logInfo(String message) {

        Log.i(TAG, message);

    }

    /**
     * Log an debug message.
     *
     * @param message debug message.
     */
    public static void logDebug(String message) {
        if (BuildConfig.DEBUG) {
            Log.d(TAG, message);
        }
    }
}
