package com.labs.bee.app.fo.ui.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.labs.bee.app.fo.model.api.response.MultipleResponse;
import com.labs.bee.app.fo.ui.component.DialogComponent;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by arysuryawan on 8/16/17.
 */


/**
 * Created by arysuryawan on 8/16/17.
 */

public abstract class BaseFragment extends Fragment {

    protected Typeface mTfRegular;
    protected Typeface mTfLight;

    protected String[] mMonths = new String[] {
            "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dec"
    };

    protected String[] mParties = new String[] {
            "Rendang Super Pedas", "Bawang Goreng", "Milkshake Mangoes", "Ice Cream Ceria", "Party E", "Party F", "Party G", "Party H",
            "Party I", "Party J", "Party K", "Party L", "Party M", "Party N", "Party O", "Party P",
            "Party Q", "Party R", "Party S", "Party T", "Party U", "Party V", "Party W", "Party X",
            "Party Y", "Party Z"
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTfRegular = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OpenSans-Regular.ttf");
        mTfLight = Typeface.createFromAsset(getActivity().getAssets(), "fonts/OpenSans-Light.ttf");
    }



    protected void onApiResponseCallback(MultipleResponse mr, String keyCallback) {
    }

    protected void onApiFailureCallback(String message) {
        // --- default callback if not defined on child class --
        Toast.makeText(getActivity(), "Error: " + message, Toast.LENGTH_LONG).show();
        Log.e("Message:", message);
    }


    public static void onResponseCallback(Call<MultipleResponse> call, Response response, BaseFragment fm, String keyCallback) {
        DialogComponent.dismissProgressDialog((BaseActivity) fm.getActivity());
        fm.onApiResponseCallback((MultipleResponse) response.body(), keyCallback);
    }

    public static void onFailureCallback(Throwable t, BaseFragment fm) {
        DialogComponent.dismissProgressDialog((BaseActivity) fm.getActivity());
        fm.onApiFailureCallback(t.getMessage());
    }


}
