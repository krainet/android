package com.walladog.walladog.controllers.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.walladog.walladog.R;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.WDServices;
import com.walladog.walladog.model.apiservices.WDServicesService;
import com.walladog.walladog.controllers.adapters.WDServicesPagerAdapter;

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



    public static MainFragment newInstance(WDServices services) {
        MainFragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(ARG_SERVICES, services);
        fragment.setArguments(arguments);

        return fragment;
    }

    public MainFragment() {
        getServices();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        final View root = inflater.inflate(R.layout.fragment_main,container,false);

        //Pager
        pager = (ViewPager) root.findViewById(R.id.view_pager);

        //Listeners
        FloatingActionButton fab = (FloatingActionButton) root.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toolbar toolbar = (Toolbar) getView().findViewById(R.id.toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) getView().findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                getActivity(), drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) getView().findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
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
        pager.setAdapter(new WDServicesPagerAdapter(getFragmentManager(), serviceList));
    }
}
