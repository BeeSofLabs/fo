package com.labs.beee.app.fo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labs.beee.app.fo.R;

import app.beelabs.com.codebase.base.BaseFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.labs.beee.app.fo.ui.adapter.MessageOutcomingAdapter;

/**
 * Created by ary on 6/19/17.
 */

public class MessageOutcomingFragment extends BaseFragment {
    @BindView(R.id.list_outcoming)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_outcoming, container, false);
        ButterKnife.bind(this, layout);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MessageOutcomingAdapter messageOutcomingAdapter = new MessageOutcomingAdapter(getActivity());
        recyclerView.setAdapter(messageOutcomingAdapter);
        return layout;
    }
}
