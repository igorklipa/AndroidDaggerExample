package com.iklipa.daggerexample.ui;

import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.Router;

/**
 * Created by iklipa on 9/10/2018.
 */

public interface ScreenNavigation {

    void initWithRouter(Router router, Controller routeScreen);

    boolean pop();

    void clear();
}
