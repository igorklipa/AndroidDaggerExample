package com.iklipa.daggerexample.di;

import com.bluelinelabs.conductor.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import dagger.MapKey;

/**
 * Created by iklipa on 9/7/2018.
 */
@MapKey
@Target(ElementType.METHOD)
public @interface ControllerKey {
    Class<? extends Controller> value();
}
