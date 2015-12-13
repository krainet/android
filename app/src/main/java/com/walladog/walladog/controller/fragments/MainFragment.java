package com.walladog.walladog.controller.fragments;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.app.Fragment;
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
import com.walladog.walladog.model.Events;
import com.walladog.walladog.model.ServiceGenerator;
import com.walladog.walladog.model.Services;
import com.walladog.walladog.model.apiservices.EventsService;
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

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    private OnWalladogItemSelectedListener OnWalladogItemSelectedListener =null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        final View root = inflater.inflate(R.layout.fragment_main, container, false);

        FloatingActionButton btnAddDog = (FloatingActionButton) root.findViewById(R.id.btn_add_dog);
        ViewPager pager = (ViewPager) root.findViewById(R.id.view_pager);
        pager.setAdapter(new ServicesPagerAdapter(getFragmentManager()));

        btnAddDog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("RAMON", "Clicked");
                //
                //
                // getMyTest();
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

    public void getMyTest() {

        EventsService testService = ServiceGenerator.createService(EventsService.class);
        Call<List<Events>> call = testService.getMultiTask();
        call.enqueue(new Callback<List<Events>>() {
            @Override
            public void onResponse(Response<List<Events>> response, Retrofit retrofit) {
                if (response.isSuccess()) {
                    Log.v("API-JSON:", response.body().toString());
                    //responseText.setText(response.body().toString());
                    List<Events> test = response.body();
                    Log.v("ANDROID-OBJECT", test.toString());
                    Log.v("FIRST NAME:", test.get(0).getName());

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

    }

    public void getServices() {

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

    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        return false;
    }

}
