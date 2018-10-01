package com.iklipa.daggerexample.data;

import dagger.Binds;
import dagger.Module;

/**
 * Created by iklipa on 10/1/2018.
 */

@Module
public abstract class TestRepoServiceModule {

    @Binds
    abstract RepoService bindREpoService(TestRepoService repoService);
}
