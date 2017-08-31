package com.labs.bee.app.fo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.labs.bee.app.fo.R;
import com.labs.bee.app.fo.ui.base.BaseActivity;
import com.labs.bee.app.fo.ui.fragment.MessageFragment;
import com.labs.bee.app.fo.ui.fragment.ShopFragment;
import com.labs.bee.app.fo.ui.fragment.StatsFragment;
import com.labs.bee.app.fo.ui.fragment.WalletFragment;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {
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


    public void topUp(View v) {
        Log.d("", "---------" + v.getTag());
        v.setBackgroundColor(getResources().getColor(R.color.app_teal));
        ((TextView) v).setTextColor(getResources().getColor(android.R.color.white));
        Intent intent = new Intent(this, PaymentActivity.class);
        startActivity(intent);

    }

}
