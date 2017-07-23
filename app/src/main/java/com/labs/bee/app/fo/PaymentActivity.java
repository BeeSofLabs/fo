package com.labs.bee.app.fo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import support.fragments.PaymentStep1Fragment;

/**
 * Created by ary on 6/29/17.
 */

public class PaymentActivity extends BaseAppCompatActivity {
    @BindView(R.id.container)
    FrameLayout container;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ButterKnife.bind(this);


        showFragment(new PaymentStep1Fragment());

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
