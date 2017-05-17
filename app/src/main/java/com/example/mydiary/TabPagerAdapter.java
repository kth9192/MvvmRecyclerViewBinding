package com.example.mydiary;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by kth919 on 2017-05-06.
 */

public class TabPagerAdapter extends FragmentPagerAdapter {

    private Context context;

    public TabPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new TabFragment1();
            case 1:
                return new TabFragment2();

            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "탭1";
            case 1:
                return "탭2";
            default:
                return null;
        }
    }

}
