package com.labs.bee.app.fo.model.api;

import android.content.Context;


import com.labs.bee.app.fo.model.api.response.MultipleResponse;

import retrofit2.Callback;


/**
 * Created by arysuryawan on 8/18/17.
 */
public class Api extends BaseApi {

    synchronized public static void doApiSources(Context context, Callback callback) {

        setupApi(context).callApiSources("en").enqueue((Callback<MultipleResponse>) callback);
    }

    synchronized public static void doApiArticles(Context context, Callback callback) {

        setupApi(context).callApiSources("en").enqueue((Callback<MultipleResponse>) callback);
    }

}
