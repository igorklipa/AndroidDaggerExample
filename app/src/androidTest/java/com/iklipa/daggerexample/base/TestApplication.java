package com.iklipa.daggerexample.base;

import android.support.test.InstrumentationRegistry;

/**
 * Created by iklipa on 10/1/2018.
 */

public class TestApplication extends MyApplication {

    @Override
    protected ApplicationComponent initComponent() {
        return DaggerTestApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static TestApplicationComponent getComponent() {
        return (TestApplicationComponent) ((TestApplication)InstrumentationRegistry.getTargetContext().getApplicationContext()).component;
    }
}
