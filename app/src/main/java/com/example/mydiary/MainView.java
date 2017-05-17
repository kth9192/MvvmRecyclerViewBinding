package com.example.mydiary;

import android.databinding.DataBindingUtil;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.mydiary.databinding.ActivityMainBinding;

public class MainView extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setMain(this);
        PagerAdapter mPagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), this);
        mainBinding.tabViewPager.setAdapter(mPagerAdapter);
        mainBinding.tabLayout.setupWithViewPager(mainBinding.tabViewPager);

//        setContentView(R.layout.activity_main);
//
//        ViewPager mviewPager = (ViewPager) findViewById(R.id.tab_viewPager);
//        PagerAdapter mpagerAdapter = new TabPagerAdapter(getSupportFragmentManager(), this);
//
//        mviewPager.setAdapter(mpagerAdapter);
//
//        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
//        mTabLayout.setupWithViewPager(mviewPager);

    }
}
