package com.labs.bee.app.fo.model.api;


import android.content.Context;

import com.labs.bee.app.fo.App;
import com.labs.bee.app.fo.presenter.di.IApi;

/**
 * Created by arysuryawan on 8/18/17.
 */

public class BaseApi {

    protected static ApiService setupApi(Context context) {

        IApi api = App.getComponent(context).getApi();
        return api.getApiService();
    }
}

