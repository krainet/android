package com.walladog.walladog.controller.activities;

/**
 * Created by f3rn4nd0 on 12/8/15.
 *
 */
import android.app.Fragment;
import android.app.ProgressDialog;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.walladog.walladog.R;
import com.walladog.walladog.controller.fragments.MainFragment;
import com.walladog.walladog.controller.fragments.ServiceFragment;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.Services;
import com.walladog.walladog.model.apiservices.ServicesService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


public class MainActivity extends AppCompatActivity implements MainFragment.OnWalladogItemSelectedListener,ServiceFragment.OnFragmentInteractionListener {

    private ProgressDialog dialog = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dialog = new ProgressDialog(this);
        dialog.setTitle("Loading Walladog...");
        dialog.show();

        getServices(dialog);

        Fragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("ARG_SERVICES",new Services());
        fragment.setArguments(arguments);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
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



    @Override
    public void onWaladogItemSelected(int wineIndex) {

    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void getServices(final ProgressDialog dialog) {

        ServicesService testService = ServiceGenerator.createService(ServicesService.class);
        Call<List<Services>> call = testService.getMultiTask();

        call.enqueue(new Callback<List<Services>>() {
            @Override
            public void onResponse(Response<List<Services>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Log.v("API-JSON:", response.body().toString());
                    List<Services> test = response.body();
                    Log.v("ANDROID-OBJECT", test.toString());
                    Log.v("FIRST NAME:", String.valueOf(test.get(0).getName()));
                    dialog.dismiss();

                } else {
                    Log.v("RAMON", "Sin respuesta");
                    dialog.dismiss();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // something went completely south (like no internet connection)
                dialog.dismiss();
                Log.d("Error", t.getMessage());
            }
        });

    }
}