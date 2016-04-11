package com.example.pci.myapplication;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {

    private final List pagelist;

    public MyPagerAdapter(FragmentManager fm, List pagelist) {
        super(fm);
        this.pagelist = pagelist;
    }

    @Override
    public Fragment getItem(int position) {
        return (Fragment) this.pagelist.get(position);
    }

    @Override
    public int getCount() {
        return this.pagelist.size();
    }
}