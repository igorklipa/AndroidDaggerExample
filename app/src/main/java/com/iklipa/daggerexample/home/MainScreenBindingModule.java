package com.iklipa.daggerexample.home;

import com.bluelinelabs.conductor.Controller;
import com.iklipa.daggerexample.di.ControllerKey;
import com.iklipa.daggerexample.trending.TrendingReposComponent;
import com.iklipa.daggerexample.trending.TrendingReposController;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by iklipa on 9/7/2018.
 */

@Module(subcomponents = {
        TrendingReposComponent.class
})
public abstract class MainScreenBindingModule {

    @Binds
    @IntoMap
    @ControllerKey(TrendingReposController.class)
    abstract AndroidInjector.Factory<? extends Controller> bindTrendingReposInjector(TrendingReposComponent.Builder builder);
}
