package com.labs.beee.app.fo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.labs.beee.app.fo.ui.PaymentActivity;
import com.labs.beee.app.fo.R;

import app.beelabs.com.codebase.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by arysuryawan on 7/22/17.
 */

public class PaymentStep1Fragment extends BaseFragment {

    @BindView(R.id.status_progress_linebar)
    ProgressBar statusProgressLinebar;
    @BindView(R.id.button_step1_payment)
    Button buttonStep1Payment;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_payment_step1, container, false);

        ButterKnife.bind(this, fragmentView);
        ((PaymentActivity) getActivity()).getSupportActionBar().setTitle(R.string.payment_step1);



        buttonStep1Payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((PaymentActivity) getActivity()).showFragment(new PaymentStep2Fragment(), R.id.container);
            }
        });

        return fragmentView;
    }
}
