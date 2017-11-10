package com.labs.beee.app.fo.ui.component;


import android.app.ProgressDialog;
import android.content.Context;

import com.labs.beee.app.fo.IConfig;
import com.labs.beee.app.fo.ui.base.BaseActivity;

/**
 * Created by arysuryawan on 8/19/17.
 */

public class DialogComponent {
    private static ProgressDialog dialog;

    synchronized public static ProgressDialog showProgressDialog(Context context, String message) {
        if (dialog == null) {
            message = message != null ? message : IConfig.DEFAULT_LOADING;

            dialog = new ProgressDialog(context);
            dialog.setMessage("..." + message);
            dialog.show();
        }

        return dialog;
    }

    public static void dismissProgressDialog(BaseActivity ac) {
        if (!ac.isFinishing()) {
            dialog.dismiss();
            dialog = null;
        }
    }
}
