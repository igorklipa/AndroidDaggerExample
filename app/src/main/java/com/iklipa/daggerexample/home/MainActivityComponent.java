package com.iklipa.daggerexample.home;

import com.iklipa.daggerexample.di.ActivityScope;
import com.iklipa.daggerexample.ui.NavigationModule;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by iklipa on 7/24/2018.
 */

@ActivityScope
@Subcomponent(modules = {
        MainScreenBindingModule.class,
        NavigationModule.class
})
public interface MainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {
        @Override
        public void seedInstance(MainActivity instance) {

        }
    }
}
