package com.weather.util;

import android.content.Context;
import android.widget.Toast;

/**
 * Utility class shared by all components in the application.
 */
public class Utils {

    /**
     * Ensure this class is only used as a utility.
     */
    private Utils() {
        throw new AssertionError();
    }

    /**
     * Show a toast message.
     */
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

}
