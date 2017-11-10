package com.labs.beee.app.fo.presenter.di.module;



import com.labs.beee.app.fo.App;
import com.labs.beee.app.fo.presenter.di.IProgress;
import com.labs.beee.app.fo.presenter.di.manager.ProgressManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by arysuryawan on 11/20/16.
 */

@Module
public class AppModule {

    private App app;

    public AppModule(App app) {
        this.app = app;
    }

    @Provides
    @Singleton
    protected IProgress provideProgressDialog() {
        return new ProgressManager();
    }

}
