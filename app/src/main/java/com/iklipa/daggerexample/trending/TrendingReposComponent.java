package com.iklipa.daggerexample.trending;

import com.iklipa.daggerexample.di.ScreenScope;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by iklipa on 9/7/2018.
 */

@ScreenScope
@Subcomponent
public interface TrendingReposComponent  extends AndroidInjector<TrendingReposController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TrendingReposController> {

    }
}
