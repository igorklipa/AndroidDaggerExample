package com.iklipa.daggerexample.home;

import com.bluelinelabs.conductor.Controller;
import com.iklipa.daggerexample.R;
import com.iklipa.daggerexample.base.BaseActivity;
import com.iklipa.daggerexample.trending.TrendingReposController;

/**
 * Created by iklipa on 7/24/2018.
 */

public class MainActivity extends BaseActivity {

    @Override
    protected int layoutRes() {
        return R.layout.main_activity;
    }

    @Override
    protected Controller initialScreen() {
        return new TrendingReposController();
    }
}
