package com.iklipa.daggerexample.base;

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
}
