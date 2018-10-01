package com.iklipa.daggerexample.data;

import javax.inject.Inject;

import io.reactivex.Single;

/**
 * Created by iklipa on 10/1/2018.
 */

public class TestRepoService implements RepoService {

    @Inject
    TestRepoService() {

    }

    @Override
    public Single<TrendingReposResponse> getTrendingRepos() {
        return null;
    }
}
