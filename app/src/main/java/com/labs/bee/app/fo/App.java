package com.labs.bee.app.fo;

import android.app.Application;
import android.content.Context;

/**
 * Created by ary on 6/16/17.
 */

public class App extends Application {

//    private static AppComponent component;

    private static Application app;

    public static Application getApplication(){
        return app;
    }

    public static Context getContext(){
        return app.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

//        component = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .build();

    }


//    public static AppComponent getComponent(Context context) {
//        return ((App) context.getApplicationContext()).component;
//    }
}
