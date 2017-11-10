package com.labs.beee.app.fo;

import android.app.Application;
import android.content.Context;

import com.labs.beee.app.fo.presenter.di.component.AppComponent;
import com.labs.beee.app.fo.presenter.di.component.DaggerAppComponent;
import com.labs.beee.app.fo.presenter.di.module.ApiServiceModule;
import com.labs.beee.app.fo.presenter.di.module.AppModule;

/**
 * Created by ary on 6/16/17.
 */

public class App extends Application {

    private static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .apiServiceModule(new ApiServiceModule(this))
                .build();
    }

    public static AppComponent getComponent(Context context) {
        return ((App) context.getApplicationContext()).component;
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
