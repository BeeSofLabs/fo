package core.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.labs.bee.app.fo.PaymentActivity;
import com.labs.bee.app.fo.R;
import com.squareup.picasso.LruCache;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ary on 6/21/17.
 */

public class WalletFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_wallet, container, false);
        ButterKnife.bind(this, layout);


        return layout;
    }

}
