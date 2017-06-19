package com.labs.bee.app.fo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.TabPagerAdapter;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tabs)
    SmartTabLayout tabs;
    @BindView(R.id.pager)
    ViewPager pager;



    private FragmentManager fragmentManager;
    private ArrayList<String> titles = new ArrayList<String>(Arrays.asList("Incoming", "Progress", "Outcoming"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        mTextMessage = (TextView) findViewById(R.id.message);

        // Initialize the ViewPager and set an adapter
        pager.setAdapter(new TabPagerAdapter(this.titles, this.getSupportFragmentManager()));

        // Bind the tabs to the ViewPager
        tabs.setViewPager(pager);
//        tabs.setBackgroundColor(getResources().getColor(R.color.colorPrimary));


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
//                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
//                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

}
