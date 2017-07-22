package com.labs.bee.app.fo;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ary on 6/16/17.
 */

public class App extends Application {

//    private static AppComponent component;

    private static Context context;

//    public static Application getApplication(){
//        return app;
//    }

    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();


//        component = DaggerAppComponent.builder()
//                .appModule(new AppModule(this))
//                .build();

    }



//    public static AppComponent getComponent(Context context) {
//        return ((App) context.getApplicationContext()).component;
//    }
}
