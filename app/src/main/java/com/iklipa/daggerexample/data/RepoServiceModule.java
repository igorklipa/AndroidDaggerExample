package com.iklipa.daggerexample.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by iklipa on 9/11/2018.
 */

@Module
public abstract class RepoServiceModule {

    @Provides
    @Singleton
    static RepoService provideRepoService(Retrofit retrofit) {
        return retrofit.create(RepoService.class);
    }
}
