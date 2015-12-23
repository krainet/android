package com.walladog.walladog.controllers.activities;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.walladog.walladog.R;
import com.walladog.walladog.WalladogApp;
import com.walladog.walladog.controllers.fragments.LoginFragment;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.User;
import com.walladog.walladog.model.UserAuth;
import com.walladog.walladog.model.WDServices;
import com.walladog.walladog.model.apiservices.WDLoginService;
import com.walladog.walladog.model.apiservices.WDServicesService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * Created by hadock on 19/12/15.
 *
 */

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnLoginClickListener {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private List<User> mUsers = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Fragment fragment = new LoginFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("ARG_LOGIN", new WDServices());
        fragment.setArguments(arguments);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.login_container, fragment)
                    .commit();
        }
    }


    @Override
    public void onLoginSubmit(String username, String password, final View currentView) {
        Log.v(TAG, "Login Delegate");


        WDLoginService loginService = ServiceGenerator.createService(WDLoginService.class);
        Call<List<User>> call = loginService.postTask(new UserAuth(username, password));

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Response<List<User>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<User> users = response.body();
                    mUsers = response.body();
                    //Intent mainIntent = new Intent().setClass(SplashActivity.this, MainActivity.class);
                    //startActivity(mainIntent);
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
