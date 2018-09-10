package com.iklipa.daggerexample.ui;

/**
 * Created by iklipa on 9/10/2018.
 */

import dagger.Binds;
import dagger.Module;

@Module
public abstract class NavigationModule {

    @Binds
    abstract ScreenNavigation provideScreenNavigation(DefaultScreenNavigation screenNavigation);
}
