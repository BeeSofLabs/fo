package com.labs.bee.app.fo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labs.bee.app.fo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.labs.bee.app.fo.ui.adapter.MessageIncomingAdapter;

/**
 * Created by ary on 6/19/17.
 */

public class MessageIncomingFragment extends Fragment {
    @BindView(R.id.list_incoming)
    RecyclerView recyclerView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_incoming, container, false);
        ButterKnife.bind(this, layout);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        MessageIncomingAdapter messageIncomingAdapter = new MessageIncomingAdapter(getActivity());
        recyclerView.setAdapter(messageIncomingAdapter);
        return layout;
    }
}
