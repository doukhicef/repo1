package com.example.pci.myapplication;

import java.util.List;
import java.util.Vector;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class swipe extends AppCompatActivity {

    private PagerAdapter mPagerAdapter;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.swipe);


        List pagelist = new Vector();

        int nbrpage = getResources().getInteger(R.integer.nbrpage);
        for(int i=1;i<=nbrpage;i++) {
            Fragment frag = com.example.pci.myapplication.frag.newInstance(i);
            pagelist.add(frag);
        }


        this.mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), pagelist);
        this.pager = (ViewPager) super.findViewById(R.id.viewpager);
        this.pager.setAdapter(this.mPagerAdapter);

    }

}