package com.labs.beee.app.fo;

import android.content.Context;

import app.beelabs.com.codebase.base.BaseApp;
import app.beelabs.com.codebase.di.component.AppComponent;
import app.beelabs.com.codebase.di.component.DaggerAppComponent;

/**
 * Created by ary on 6/16/17.
 */

public class App extends BaseApp {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        setupBuilder(DaggerAppComponent.builder(), this);
    }

    public static Context getContext() {
        return context;
    }

    public static AppComponent getAppComponent() {
        if (context == null) return null;
        return getComponent();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
