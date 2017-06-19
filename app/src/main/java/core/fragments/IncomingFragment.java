package core.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.labs.bee.app.fo.R;

import butterknife.ButterKnife;

/**
 * Created by ary on 6/19/17.
 */

public class IncomingFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_incoming, container, false);
        ButterKnife.bind(this, layout);
        return layout;
    }
}
