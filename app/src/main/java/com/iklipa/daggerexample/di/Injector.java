package com.iklipa.daggerexample.di;

import android.app.Activity;

/**
 * Created by iklipa on 7/30/2018.
 */

public class Injector {

    private Injector() {

    }

    public static void inject(Activity activity) {
        ActivityInjector.get(activity).inject(activity);
    }

    public static void clearComponent(Activity activity) {
        ActivityInjector.get(activity).clear(activity);
    }
}
