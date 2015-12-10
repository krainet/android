package com.walladog.walladog.controller.activities;

/**
 * Created by f3rn4nd0 on 12/8/15.
 *
 */
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.gcm.Task;
import com.walladog.walladog.R;
import com.walladog.walladog.controller.fragment.MainFragment;
import com.walladog.walladog.model.MyTest;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.interfaces.MyTestService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getMyTest();



        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new MainFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the com.walladog.walladog.menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }

    public void getMyTest() {

        MyTestService testService = ServiceGenerator.createService(MyTestService.class);
        Call<List<MyTest>> call = testService.getTasks();
        call.enqueue(new Callback<List<MyTest>>() {
            @Override
            public void onResponse(Response<List<MyTest>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Log.v("RAMON",response.body().toString());
                } else {
                    Log.v("RAMON","Sin respuesta");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

    }
}