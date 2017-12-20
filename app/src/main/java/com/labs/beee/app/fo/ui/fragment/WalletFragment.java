package com.labs.beee.app.fo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labs.beee.app.fo.R;

import app.beelabs.com.codebase.base.BaseFragment;
import butterknife.ButterKnife;

/**
 * Created by ary on 6/21/17.
 */

public class WalletFragment extends BaseFragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_wallet, container, false);
        ButterKnife.bind(this, layout);


        return layout;
    }

}
