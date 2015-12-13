package com.walladog.walladog.controller.adapters;


import android.support.v13.app.FragmentPagerAdapter;

import com.walladog.walladog.controller.fragments.ServiceFragment;

/**
 * Created by hadock on 12/12/15.
 *
 */

public class ServicesPagerAdapter extends FragmentPagerAdapter {

    public ServicesPagerAdapter(android.app.FragmentManager fragmentManager) {
        super(fragmentManager);

    }

    @Override
    public android.app.Fragment getItem(int position) {
        return ServiceFragment.newInstance("Hola", "hola");
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Ramon"+position;
    }
}
