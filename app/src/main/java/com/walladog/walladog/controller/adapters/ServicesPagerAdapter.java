package com.walladog.walladog.controller.adapters;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;

import com.walladog.walladog.controller.fragments.ServiceFragment;
import com.walladog.walladog.model.Services;

import java.util.List;

/**
 * Created by hadock on 12/12/15.
 *
 */

public class ServicesPagerAdapter extends FragmentPagerAdapter {

    private List<Services> mServices;

    public ServicesPagerAdapter(android.app.FragmentManager fragmentManager,List<Services> services) {
        super(fragmentManager);
        mServices = services;
    }

    @Override
    public android.app.Fragment getItem(int position) {
        Fragment fragment = new ServiceFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(ServiceFragment.ARG_WDSERVICE,mServices.get(position));
        fragment.setArguments(arguments);
        return fragment;
    }

    @Override
    public int getCount() {
        return mServices.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mServices.get(position).getName();
    }
}
