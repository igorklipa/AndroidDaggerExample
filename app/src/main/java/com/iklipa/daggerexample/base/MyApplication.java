package com.iklipa.daggerexample.base;

import android.app.Application;

import com.iklipa.daggerexample.di.ActivityInjector;

import javax.inject.Inject;

/**
 * Created by iklipa on 7/24/2018.
 */

public class MyApplication extends Application {

    @Inject
    ActivityInjector activityInjector;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        component.inject(this);
    }

    public ActivityInjector  getActivityInjector() {
        return activityInjector;
    }
}
