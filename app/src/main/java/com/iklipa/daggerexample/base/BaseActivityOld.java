package com.iklipa.daggerexample.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Conductor;
import com.bluelinelabs.conductor.Controller;
import com.bluelinelabs.conductor.ControllerChangeHandler;
import com.bluelinelabs.conductor.Router;
import com.iklipa.daggerexample.R;
import com.iklipa.daggerexample.di.Injector;
import com.iklipa.daggerexample.di.ScreenInjector;
import com.iklipa.daggerexample.ui.ScreenNavigation;

import java.util.UUID;

import javax.inject.Inject;

/**
 * Created by iklipa on 9/14/2018.
 */

public abstract class BaseActivityOld extends AppCompatActivity {

    private static final String INSTANCE_ID_KEY = "instance_id";

    @Inject
    ScreenInjector screenInjector;
    @Inject
    ScreenNavigation screenNavigation;

    private String instanceId;
    private Router router;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        if (savedInstanceState != null) {
            instanceId = savedInstanceState.getString(INSTANCE_ID_KEY);
        } else {
            instanceId = UUID.randomUUID().toString();
        }
        Injector.inject(this);
        super.onCreate(savedInstanceState);

        setContentView(layoutRes());
        ViewGroup screenContainer = findViewById(R.id.screen_container);
        if (screenContainer == null) {
            throw new NullPointerException("Activity must have a view with id: screen_container");
        }
        router = Conductor.attachRouter(this, screenContainer, savedInstanceState);
        screenNavigation.initWithRouter(router, initialScreen());
        monitorBackstack();
    }

    @LayoutRes
    protected abstract int layoutRes();

    protected abstract Controller initialScreen();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INSTANCE_ID_KEY, instanceId);
    }

    @Override
    public void onBackPressed() {
        if (!screenNavigation.pop()) {
            super.onBackPressed();
        }
    }

    public String getInstanceId() {
        return instanceId;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        screenNavigation.clear();
        if (isFinishing()) {
            Injector.clearComponent(this);
        }
    }

    public ScreenInjector getScreenInjector() {
        return screenInjector;
    }

    private void monitorBackstack() {
        router.addChangeListener(new ControllerChangeHandler.ControllerChangeListener() {
            @Override
            public void onChangeStarted(@Nullable Controller to, @Nullable Controller from, boolean isPush, @NonNull ViewGroup container, @NonNull ControllerChangeHandler handler) {

            }

            @Override
            public void onChangeCompleted(@Nullable Controller to, @Nullable Controller from, boolean isPush, @NonNull ViewGroup container, @NonNull ControllerChangeHandler handler) {
                if (!isPush && from != null) {
                    Injector.clearComponent(from);
                }
            }
        });
    }
}
