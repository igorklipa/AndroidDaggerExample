package com.iklipa.daggerexample.di;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by iklipa on 9/6/2018.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ScreenScope  {
}
