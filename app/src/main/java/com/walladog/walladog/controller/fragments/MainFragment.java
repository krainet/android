package com.walladog.walladog.controller.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
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
import com.walladog.walladog.controller.adapters.ServicesPagerAdapter;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.Services;
import com.walladog.walladog.model.apiservices.ServicesService;

import java.util.List;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;


/**
 * Created by f3rn4nd0 on 12/8/15.
 *
 */

public class MainFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = MainFragment.class.getName();

    private static final String ARG_SERVICES = "services";
    private List<Services> services = null;
    private ViewPager pager = null;

    private OnWalladogItemSelectedListener OnWalladogItemSelectedListener = null;

    public static MainFragment newInstance(Services services) {
        MainFragment fragment = new MainFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(ARG_SERVICES, services);
        fragment.setArguments(arguments);

        return fragment;
    }

    public MainFragment() {
        getServices();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);
        Services services = (Services) getArguments().getSerializable(ARG_SERVICES);

        // Link with view
        FloatingActionButton btnAddDog = (FloatingActionButton) root.findViewById(R.id.btn_add_dog);
        pager = (ViewPager) root.findViewById(R.id.view_pager);

        //Set listeners
        btnAddDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG, "Clicked");
                getServices();
            }
        });

        return root;
    }

    public interface OnWalladogItemSelectedListener {
        void onWaladogItemSelected(int wineIndex);
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



    public void getServices() {
        ServicesService testService = ServiceGenerator.createService(ServicesService.class);
        Call<List<Services>> call = testService.getMultiTask();

        call.enqueue(new Callback<List<Services>>() {
            @Override
            public void onResponse(Response<List<Services>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<Services> test = response.body();
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

    private void syncViewWithModel(List<Services> serviceList){
        //Set adapter of viewPager
        pager.setAdapter(new ServicesPagerAdapter(getFragmentManager(), serviceList));
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }






/*    public void getMyTest() {

        EventsService testService = ServiceGenerator.createService(EventsService.class);
        Call<List<Events>> call = testService.getMultiTask();
        call.enqueue(new Callback<List<Events>>() {
            @Override
            public void onResponse(Response<List<Events>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    List<Events> test = response.body();
                    Log.v(TAG, test.get(0).getName());

                } else {
                    Log.v("RAMON", "Sin respuesta");
                }
            }

            @Override
            public void onFailure(Throwable t) {
                // something went completely south (like no internet connection)
                Log.d("Error", t.getMessage());
            }
        });

    }*/


}
