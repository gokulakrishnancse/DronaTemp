package com.example.gokulakrishnan.dronatemp;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Gokulakrishnan on 6/29/2020.
 */

public class FragmentTabAdapter extends FragmentPagerAdapter {
    public FragmentTabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position==0)
            return new ArraivalFragment();
        else
        return new DepatureFragment();


    }

    @Override
    public int getCount() {
        return 2;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:return "arraival";
            case 1:return  "depature";
            default: return null;
        }
       // return super.getPageTitle(position);
    }
}
