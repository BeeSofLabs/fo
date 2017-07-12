package core.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labs.bee.app.fo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import core.adapter.MenuAdapter;

/**
 * Created by ary on 6/20/17.
 */

public class ShopFragment extends Fragment {
    @BindView(R.id.list_menu)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_shop, container, false);
        ButterKnife.bind(this, layout);

        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Shop");

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerView.setAdapter(new MenuAdapter());

        return layout;
    }
}
