package com.walladog.walladog;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by hadock on 9/12/15.
 *
 */

public class WalladogApp extends Application {

    private static WeakReference<Context> context;

    @Override
    public void onCreate() {
        super.onCreate();
        final Context c = getApplicationContext();
        context = new WeakReference<Context>(c);

        Log.d(WalladogApp.class.getCanonicalName(), getString(R.string.walladog_started));
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        Log.d(WalladogApp.class.getCanonicalName(), getString(R.string.walladog_low_memory));
    }


    // Tenemos contexto desde donde queramos ;D
    public static WeakReference<Context> getContext() {
        return context;
    }
}
