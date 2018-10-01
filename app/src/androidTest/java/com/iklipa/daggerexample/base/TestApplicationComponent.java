package com.iklipa.daggerexample.base;

import com.iklipa.daggerexample.data.TestRepoServiceModule;
import com.iklipa.daggerexample.networking.ServiceModule;
import com.iklipa.daggerexample.ui.NavigationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by iklipa on 10/1/2018.
 */

@Singleton
@Component(modules = {
        ApplicationModule.class,
        TestActivityBindingModule.class,
        TestRepoServiceModule.class,
        ServiceModule.class,
        NavigationModule.class
})
public interface TestApplicationComponent extends ApplicationComponent {
}
