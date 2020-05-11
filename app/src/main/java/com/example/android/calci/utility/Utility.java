package com.example.android.calci.utility;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author Abhishek Saxena
 * @since 19/8/19 1:18 PM
 */

public class Utility {
    public static int calculateNoOfColumns(Context context, float columnWidthDp) { // For example columnWidthdp=180
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float screenWidthDp = displayMetrics.widthPixels / displayMetrics.density;
        return (int) (screenWidthDp / columnWidthDp + 0.5);
    }
}
