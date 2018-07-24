package com.iklipa.daggerexample.base;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by iklipa on 7/24/2018.
 */

@Module
public class ApplicationModule {

    private final Application application;

    ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides Context provideApplicationContext() {
        return application;
    }
}
