package com.labs.beee.app.fo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.labs.beee.app.fo.model.api.response.MultipleResponse;

import app.beelabs.com.codebase.base.BaseFragment;
import app.beelabs.com.codebase.base.response.BaseResponse;
import retrofit2.Response;


/**
 * Created by arysuryawan on 8/21/17.
 */

public class MainFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    protected void onApiResponseCallback(Response response, BaseResponse mr, int keyCallback) {
        if (mr.getStatus().equals("ok")) {
            Toast.makeText(getActivity(), "Status: OK, Size= " + ((MultipleResponse)mr).getSources().size(), Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "Status: 200, but error", Toast.LENGTH_LONG).show();
        }
    }


}
