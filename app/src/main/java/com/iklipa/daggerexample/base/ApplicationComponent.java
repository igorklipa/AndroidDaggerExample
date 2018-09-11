package com.iklipa.daggerexample.base;

import android.app.Application;
import android.app.Service;

import com.iklipa.daggerexample.data.RepoServiceModule;
import com.iklipa.daggerexample.networking.ServiceModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by iklipa on 7/24/2018.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        ActivityBindingModule.class,
        ServiceModule.class,
        RepoServiceModule.class,
})
public interface ApplicationComponent {
    void inject(Application application);
}
