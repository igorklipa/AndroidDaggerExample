package com.iklipa.daggerexample.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;
import com.bluelinelabs.conductor.RouterTransaction;
import com.iklipa.daggerexample.di.ActivityScope;

/**
 * Created by iklipa on 9/10/2018.
 */

@ActivityScope
public class DefaultScreenNavigation implements ScreenNavigation {

    private Router router;

    @Override
    public void initWithRouter(Router router, Controller routeScreen) {
        this.router = router;
        if(!router.hasRootController()) {
            router.setRoot(RouterTransaction.with(routeScreen));
        }
    }

    @Override
    public boolean pop() {
        return router != null  && router.handleBack();
    }

    @Override
    public void clear() {
        router = null;
    }
}
