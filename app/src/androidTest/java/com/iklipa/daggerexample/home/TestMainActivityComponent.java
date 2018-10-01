package com.iklipa.daggerexample.home;

import com.iklipa.daggerexample.di.ActivityScope;
import com.iklipa.daggerexample.trending.TrendingReposController;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by iklipa on 10/1/2018.
 */

@ActivityScope
@Subcomponent(modules =  {
        TestScreenBindingModule.class
})
public interface TestMainActivityComponent extends AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity> {

    }
}
