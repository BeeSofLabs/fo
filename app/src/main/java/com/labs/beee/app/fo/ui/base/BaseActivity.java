package com.labs.beee.app.fo.ui.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.labs.beee.app.fo.App;
import com.labs.beee.app.fo.R;
import com.labs.beee.app.fo.model.api.response.MultipleResponse;
import com.labs.beee.app.fo.presenter.dao.BaseDao;
import com.labs.beee.app.fo.presenter.di.IProgress;
import com.labs.beee.app.fo.ui.component.DialogComponent;

import retrofit2.Call;
import retrofit2.Response;
import com.labs.beee.app.fo.presenter.bus.MessageBus;
import de.greenrobot.event.EventBus;
import de.greenrobot.event.Subscribe;
import de.greenrobot.event.ThreadMode;

/**
 * Created by ary on 6/20/17.
 */

public class BaseActivity extends AppCompatActivity {


    public void showFragment(Fragment fragment) {

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.detach(fragment);
            fragmentTransaction.attach(fragment);
            fragmentTransaction.commit();
        }
    }

    protected EventBus getEventBus() {
        return EventBus.getDefault();
    }

    @Subscribe(threadMode = ThreadMode.PostThread)
    public void onMessageEvent(MessageBus event) {
        Toast.makeText(this, event.message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getEventBus().register(this);
    }

    @Override
    protected void onStop() {
        getEventBus().unregister(this);
        super.onStop();
    }




    protected void onApiResponseCallback(MultipleResponse mr, String keyCallback) {
    }

    protected void onApiFailureCallback(String message) {
        // --- default callback if not defined on child class --
        Toast.makeText(this, "Error: " + message, Toast.LENGTH_LONG).show();
        Log.e("Message:", message);
    }

    protected void showProgressDialog(BaseDao dao) {
        showProgressDialog(dao, null);
    }

    protected void showProgressDialog(BaseDao dao, String message) {
        IProgress progress = App.getComponent(this).getProgressDialog();
        progress.showProgressDialog(this, message);
        dao.call();
    }


    public static void onResponseCallback(Call<MultipleResponse> call, Response response, BaseActivity ac, String keyCallback) {
        DialogComponent.dismissProgressDialog(ac);
        ac.onApiResponseCallback((MultipleResponse) response.body(), keyCallback);
    }

    public static void onFailureCallback(Throwable t, BaseActivity ac) {
        DialogComponent.dismissProgressDialog(ac);
        ac.onApiFailureCallback(t.getMessage());
    }


}
