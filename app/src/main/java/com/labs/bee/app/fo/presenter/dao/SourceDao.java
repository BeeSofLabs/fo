package com.labs.bee.app.fo.presenter.dao;

import com.labs.bee.app.fo.ui.base.BaseActivity;
import com.labs.bee.app.fo.model.api.Api;

import retrofit2.Callback;

/**
 * Created by arysuryawan on 8/19/17.
 */

public class SourceDao extends BaseDao {

    public SourceDao(BaseActivity ac) {
        super(ac);
    }

    public void getSourcesDAO(BaseActivity ac, Callback callback) {
        Api.doApiSources(ac, callback);
    }
}
