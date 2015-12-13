package com.walladog.walladog.utils;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;

/**
 * Created by hadock on 13/12/15.
 *
 */
public class Utils {

    public static boolean isNetworkAvailable(Context c) {
        ConnectivityManager connectivityManager = (ConnectivityManager)c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager
                .getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public static void messageDialog(Activity a, String title, String message){
        AlertDialog.Builder dialog = new AlertDialog.Builder(a);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setNeutralButton("OK", null);
        dialog.create().show();

    }

}
