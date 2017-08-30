package com.labs.bee.app.fo.presenter.di.component;



import com.labs.bee.app.fo.presenter.di.IApi;
import com.labs.bee.app.fo.presenter.di.IProgress;
import com.labs.bee.app.fo.presenter.di.module.ApiServiceModule;
import com.labs.bee.app.fo.presenter.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by arysuryawan on 11/20/16.
 */

@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class})
public interface AppComponent {

    IApi getApi();

    IProgress getProgressDialog();

}
