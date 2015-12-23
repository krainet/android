package com.walladog.walladog.controllers.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.walladog.walladog.R;
import com.walladog.walladog.controllers.fragments.LoginFragment;
import com.walladog.walladog.controllers.fragments.MainFragment;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.User;
import com.walladog.walladog.model.UserAuth;
import com.walladog.walladog.model.WDServices;
import com.walladog.walladog.model.apiservices.WDLoginService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends AppCompatActivity
        implements LoginFragment.OnLoginClickListener {

    private static final String TAG = MainActivity.class.getName();
    private List<User> mUsers = null;
    private View mDefaultView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("ARG_SERVICES", new WDServices());
        fragment.setArguments(arguments);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, fragment)
                    .addToBackStack(MainFragment.class.getName())
                    .commit();
        }

    }


    @Override
    public void onBackPressed() {
        final FragmentManager fm = getFragmentManager();
        MainFragment mFragment = (MainFragment) fm.findFragmentByTag("MainFragment");

        if (mFragment != null && mFragment.isVisible()) {
            new android.app.AlertDialog.Builder(this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setMessage(R.string.sure_exit)
                    .setPositiveButton(getString(R.string.app_yes), new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .setNegativeButton(getString(R.string.app_no), new OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(getApplicationContext(), "Gracias por seguir con nosotros!", Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }else {
            Log.v(TAG, "Not in main Fragment");
            if(fm.getBackStackEntryCount()>0){
                fm.popBackStack();
            }

        }

        //super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onLoginSubmit(String username, String password, final View currentView) {
        WDLoginService loginService = ServiceGenerator.createService(WDLoginService.class);
        Call<List<User>> call = loginService.postTask(new UserAuth(username, password));

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<User> users = response.body();
                    mUsers = response.body();
                    getFragmentManager().beginTransaction()
                            .replace(R.id.container,LoginFragment.newInstance())
                            .commit();
                    Log.v(TAG, String.valueOf(mUsers.get(0).getDetail().getLatitude()));
                    Snackbar.make(currentView, R.string.login_success, Snackbar.LENGTH_LONG).show();
                } else {
                    Log.v(TAG, "No api response");
                    Snackbar.make(currentView, R.string.login_error, Snackbar.LENGTH_LONG).show();
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
