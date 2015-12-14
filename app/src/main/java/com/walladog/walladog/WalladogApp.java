package com.walladog.walladog;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by hadock on 14/12/15.
 *
 */

public class WalladogApp extends Application {

    private static WeakReference<Context> context;

    @Override
    public void onCreate() {
        super.onCreate();
        final Context c = getApplicationContext();
        context = new WeakReference<Context>(c);

        Log.d(WalladogApp.class.getCanonicalName(), "Walladog Iniciado...");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        Log.d(WalladogApp.class.getCanonicalName(), "Walladog memory Alert!");
    }


    // Tenemos contexto desde donde queramos ;D
    public static WeakReference<Context> getContext() {
        return context;
    }
}
