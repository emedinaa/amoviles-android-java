
package com.emedinaa.myfirstapp.ui.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.emedinaa.myfirstapp.ui.fragments.ATabFragment;
import com.emedinaa.myfirstapp.ui.fragments.BTabFragment;
import com.emedinaa.myfirstapp.ui.fragments.CTabFragment;


/**
 * Created by eduardo on 03/09/16.
 */
public  class AppSectionsPagerAdapter extends FragmentPagerAdapter {
//public  class AppSectionsPagerAdapter extends FragmentStatePagerAdapter {

    public AppSectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ATabFragment();
            case 1:
                return new BTabFragment();
            case 2:
                return new CTabFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Section " + (position + 1);
    }
}