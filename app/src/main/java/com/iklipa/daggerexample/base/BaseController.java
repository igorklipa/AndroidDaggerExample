package com.iklipa.daggerexample.base;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bluelinelabs.conductor.Controller;
import com.iklipa.daggerexample.di.Injector;

/**
 * Created by iklipa on 9/7/2018.
 */

public abstract class BaseController extends Controller {

    private boolean injected = false;

    protected void onContextAvailable(@NonNull Context context) {
        if (!injected) {
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }
}
