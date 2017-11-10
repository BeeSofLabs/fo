package com.labs.beee.app.fo.presenter.di.manager;


import android.content.Context;

import com.labs.beee.app.fo.presenter.di.IProgress;
import com.labs.beee.app.fo.ui.component.DialogComponent;

/**
 * Created by ary on 5/28/17.
 */

public class ProgressManager implements IProgress {
    @Override
    public void showProgressDialog(Context context, String message) {
        DialogComponent.showProgressDialog(context, message);
    }
}
