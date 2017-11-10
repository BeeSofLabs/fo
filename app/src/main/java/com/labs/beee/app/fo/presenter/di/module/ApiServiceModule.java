package com.labs.beee.app.fo.presenter.di.module;

import android.content.Context;

import com.labs.beee.app.fo.presenter.di.IApi;
import com.labs.beee.app.fo.presenter.di.manager.ApiManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by arysuryawan on 8/20/17.
 */

@Module
public class ApiServiceModule {

    private final Context context;

    public ApiServiceModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    protected IApi provideApi(){
        return new ApiManager();
    }
}
