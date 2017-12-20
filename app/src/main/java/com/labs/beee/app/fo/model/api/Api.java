package com.labs.beee.app.fo.model.api;

import android.content.Context;


import com.labs.beee.app.fo.App;
import com.labs.beee.app.fo.IConfig;
import com.labs.beee.app.fo.model.api.response.MultipleResponse;

import app.beelabs.com.codebase.base.BaseApi;
import retrofit2.Callback;

/**
 * Created by arysuryawan on 8/18/17.
 */
public class Api extends BaseApi {

    synchronized private static ApiService initApiDomain(Context context) {
        setApiDomain(IConfig.API_BASE_URL);
        return (ApiService) setupApi(App.getAppComponent(), ApiService.class);
    }

    synchronized public static void doApiSources(Context context, Callback callback) {

        initApiDomain(context).callApiSources("en").enqueue((Callback<MultipleResponse>) callback);
    }

    synchronized public static void doApiArticles(Context context, Callback callback) {

        initApiDomain(context).callApiSources("en").enqueue((Callback<MultipleResponse>) callback);
    }

}
