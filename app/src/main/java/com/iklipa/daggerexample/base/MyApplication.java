package com.iklipa.daggerexample.base;

import android.app.Application;

/**
 * Created by iklipa on 7/24/2018.
 */

public class MyApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }
}
