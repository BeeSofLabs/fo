package com.labs.beee.app.fo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labs.beee.app.fo.IConfig;
import com.labs.beee.app.fo.R;
import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.Arrays;

import app.beelabs.com.codebase.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.labs.beee.app.fo.ui.adapter.TabPagerAdapter;

/**
 * Created by ary on 6/20/17.
 */

public class MessageFragment extends BaseFragment {

    @BindView(R.id.tabs)
    SmartTabLayout tabs;
    @BindView(R.id.pager)
    ViewPager pager;


    private FragmentManager fragmentManager;
    private ArrayList<String> titles = new ArrayList<String>(Arrays.asList(IConfig.INCOMING_TAB_NAME,
            IConfig.PROCESS_TAB_NAME, IConfig.OUTCOMING_TAB_NAME));


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_message, container, false);
        ButterKnife.bind(this, layout);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Order");
        // Initialize the ViewPager and set an adapter
        pager.setAdapter(new TabPagerAdapter(this.titles, getActivity().getSupportFragmentManager()));

        // Bind the tabs to the ViewPager
        tabs.setViewPager(pager);
        return layout;
    }
}
