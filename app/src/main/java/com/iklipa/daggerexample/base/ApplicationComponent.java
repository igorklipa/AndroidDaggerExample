package com.iklipa.daggerexample.base;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by iklipa on 7/24/2018.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
})
public interface ApplicationComponent {
    void inject(Application application);
}
