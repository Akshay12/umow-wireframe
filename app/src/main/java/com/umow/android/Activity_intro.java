package com.umow.android;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
//import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.Vector;



public class Activity_intro extends FragmentActivity {


        /** maintains the pager adapter*/
        private Pager_Adapter mPagerAdapter1;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            super.setContentView(R.layout.intro_base);
            //initialsie the pager
            this.initialisePaging();
        }

        /**
         * Initialise the fragments to be paged
         */
        private void initialisePaging() {

            List<Fragment> fragments = new Vector<Fragment>();
            fragments.add(Fragment.instantiate(this, FragmentA.class.getName()));
            fragments.add(Fragment.instantiate(this, FragmentC.class.getName()));
            this.mPagerAdapter1  = new Pager_Adapter(super.getSupportFragmentManager(), fragments);
            //
            ViewPager pager = (ViewPager)super.findViewById(R.id.pager);
            pager.setAdapter(this.mPagerAdapter1);
        }





   /* ViewPager Tab;
    TabPagerAdapter TabAdapter;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_base);

        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());

        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {

                        actionBar = getActionBar();
                        actionBar.setSelectedNavigationItem(position);                    }
                });
        Tab.setAdapter(TabAdapter);

        actionBar = getActionBar();
        //Enable Tabs on Action Bar
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){

            @Override
            public void onTabReselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

                Tab.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub

            }};
        //Add New Tab
        actionBar.addTab(actionBar.newTab().setText("logo").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("about").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("pricing").setTabListener(tabListener));

    }


*/

}


