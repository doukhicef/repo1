package com.example.pci.myapplication;

import java.util.List;
import java.util.Vector;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class swipe extends AppCompatActivity {

    private PagerAdapter mPagerAdapter;
    private ViewPager pager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.swipe);


        List pagelist = new Vector();

        int nbrpage = getResources().getInteger(R.integer.nbrpage);
        for(int i=nbrpage;i>=1;i--) {
            Fragment frag = com.example.pci.myapplication.frag.newInstance(i);
            pagelist.add(frag);
        }


        this.mPagerAdapter = new MyPagerAdapter(super.getSupportFragmentManager(), pagelist);
        this.pager = (ViewPager) super.findViewById(R.id.viewpager);
        this.pager.setAdapter(this.mPagerAdapter);
        this.pager.setCurrentItem(nbrpage-1);


        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == pager.getCurrentItem()) {
                    //Log.e("going Right", "going Right");
                } else {
                    //Log.e("going left", "going left");
                }

            }

            @Override
            public void onPageSelected(int position) {
                //Log.e("Select",String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Log.e("Select Scroll","Select Scroll");
            }

        });

    }
}