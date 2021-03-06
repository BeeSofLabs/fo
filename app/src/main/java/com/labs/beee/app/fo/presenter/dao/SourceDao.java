package com.labs.beee.app.fo.presenter.dao;

import com.labs.beee.app.fo.model.api.Api;

import app.beelabs.com.codebase.base.BaseActivity;
import app.beelabs.com.codebase.base.BaseDao;
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
