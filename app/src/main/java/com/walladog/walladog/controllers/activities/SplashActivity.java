package com.walladog.walladog.controllers.activities;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.ProgressBar;

import com.walladog.walladog.R;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.WDServices;
import com.walladog.walladog.model.apiservices.WDServicesService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hadock on 14/12/15.
 *
 */
public class SplashActivity extends Activity {

    private static final String TAG = SplashActivity.class.getName();
    private long splashDelay = 3000; // 6 segundos
    public ProgressBar progressBar;
    private boolean firstUse;
    private Uri URLScheme = null;

    private List<WDServices> services = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Intent intent = getIntent();
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run() {
                getServices();
            }
        }, splashDelay);
    }


    //Helper Functions
    public void getServices() {
        WDServicesService testService = ServiceGenerator.createService(WDServicesService.class);
        Call<List<WDServices>> call = testService.getMultiTask();

        call.enqueue(new Callback<List<WDServices>>() {
            @Override
            public void onResponse(Response<List<WDServices>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<WDServices> test = response.body();
                    services = response.body();
                    Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                    startActivity(mainIntent);
                    Log.v(TAG, String.valueOf(test.get(0).getName()));

                } else {
                    Log.v(TAG, "No api response");

                }
            }

            @Override
            public void onFailure(Throwable t) {
                // something went completely south (like no internet connection)
                Log.d(TAG, t.getMessage());
            }
        });

    }





}
