package com.labs.bee.app.fo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 6/29/17.
 */

public class PaymentActivity extends BaseAppCompatActivity {
    @BindView(R.id.status_progress_linebar)
    ProgressBar statusProgressLinebar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ButterKnife.bind(this);

//        statusProgressLinebar.setScaleY(3f);

    }
}
