package com.walladog.walladog.controllers.fragments;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.walladog.walladog.R;
import com.walladog.walladog.controllers.activities.LoginActivity;
import com.walladog.walladog.controllers.adapters.WDServicesPagerAdapter;
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

public class MainFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainFragment.class.getName();
    private static final String ARG_SERVICES = "services";
    private List<WDServices> services = null;
    private ViewPager pager = null;
    private LoginFragment.OnLoginClickListener mOnLoginClickListener=null;
    private DrawerLayout mDrawer = null;



    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public MainFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View root = inflater.inflate(R.layout.fragment_main,container,false);
        getServices();

        //Pager
        pager = (ViewPager) root.findViewById(R.id.view_pager);

        //Listeners
        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                startActivity(i);
            }
        });



        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        mDrawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        mDrawer.closeDrawer(Gravity.LEFT);
        toggle.syncState();


        NavigationView navigationView = (NavigationView) getView().findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_home) {
            getFragmentManager().beginTransaction()
                    .addToBackStack(MainFragment.class.getName())
                    .replace(R.id.main_linear, MainFragment.newInstance())
                    .commit();
        } else if (id == R.id.nav_login) {
            getFragmentManager().beginTransaction()
                    .addToBackStack(LoginFragment.class.getName())
                    .replace(R.id.main_linear, LoginFragment.newInstance())
                    .commit();
        } else {
            Log.v(TAG, "Class selected");
            Log.v(TAG, String.valueOf(id));

        }

        return true;
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
                    syncViewWithModel(services);
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

    private void syncViewWithModel(List<WDServices> serviceList){
        //Set adapter of viewPager
        pager.setAdapter(new WDServicesPagerAdapter(getChildFragmentManager(), serviceList));
        mDrawer.closeDrawer(Gravity.LEFT);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
