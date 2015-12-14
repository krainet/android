package com.walladog.walladog.controllers.adapters;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v13.app.FragmentPagerAdapter;
import com.walladog.walladog.controllers.fragments.WDServiceFragment;
import com.walladog.walladog.model.WDServices;

import java.util.List;

/**
 * Created by hadock on 12/12/15.
 *
 */

public class WDServicesPagerAdapter extends FragmentPagerAdapter {

    private List<WDServices> mServices;

    public WDServicesPagerAdapter(android.app.FragmentManager fragmentManager,List<WDServices> services) {
        super(fragmentManager);
        mServices = services;
    }

    @Override
    public android.app.Fragment getItem(int position) {
        Fragment fragment = new WDServiceFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable(WDServiceFragment.ARG_WDSERVICE,mServices.get(position));
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