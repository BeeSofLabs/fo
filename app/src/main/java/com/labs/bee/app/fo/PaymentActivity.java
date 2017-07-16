package com.labs.bee.app.fo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 6/29/17.
 */

public class PaymentActivity extends BaseAppCompatActivity {
    @BindView(R.id.status_progress_linebar)
    ProgressBar statusProgressLinebar;
    @BindView(R.id.button_step1_payment)
    Button buttonStep1Payment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        ButterKnife.bind(this);

        getSupportActionBar().setTitle(R.string.payment_step1);

//        statusProgressLinebar.setScaleY(3f);

        buttonStep1Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statusProgressLinebar.setProgress(100);
                getSupportActionBar().setTitle(R.string.payment_step2);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
