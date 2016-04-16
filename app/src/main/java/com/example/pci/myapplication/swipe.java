package com.example.pci.myapplication;

import java.util.List;
import java.util.Vector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

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

        Intent i = getIntent();
        int page = i.getIntExtra("page", 1);
        this.pager.setCurrentItem(nbrpage-page);

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

    public boolean onCreateOptionsMenu(Menu menu) {

        //Création d'un MenuInflater qui va permettre d'instancier un Menu XML en un objet Menu
        MenuInflater inflater = getMenuInflater();
        //Instanciation du menu XML spécifier en un objet Menu
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //Méthode qui se déclenchera au clic sur un item
    public boolean onOptionsItemSelected(MenuItem item) {
        //On regarde quel item a été cliqué grâce à son id et on déclenche une action
        switch (item.getItemId()) {
            case R.id.option:

                Toast.makeText(swipe.this, String.valueOf(this.pager.getCurrentItem()), Toast.LENGTH_SHORT).show();
                return true;
            case R.id.quitter:
                Toast.makeText(swipe.this, "Quitter", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

}