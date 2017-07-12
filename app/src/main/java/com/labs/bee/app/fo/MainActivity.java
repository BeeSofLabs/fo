package com.labs.bee.app.fo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.TabPagerAdapter;
import core.fragments.MessageFragment;
import core.fragments.ShopFragment;
import core.fragments.StatsFragment;
import core.fragments.WalletFragment;

public class MainActivity extends BaseAppCompatActivity {
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        showFragment(new MessageFragment());
    }


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_message:
                    showFragment(new MessageFragment());
                    return true;
                case R.id.navigation_stats:
                    showFragment(new StatsFragment());
                    return true;
                case R.id.navigation_shop:
                    showFragment(new ShopFragment());
                    return true;
                case R.id.navigation_wallet:
                    showFragment(new WalletFragment());
                    return true;
            }
            return false;
        }

    };


    public void topUp(View v){
        Log.d("", "---------"+v.getTag());
        v.setBackgroundColor(getResources().getColor(R.color.app_green_soft));
        ((TextView) v).setTextColor(getResources().getColor(android.R.color.white));
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);

    }

}
