package com.iklipa.daggerexample.data;

import com.iklipa.daggerexample.models.Repo;
import com.iklipa.daggerexample.test.TestUtils;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

/**
 * Created by iklipa on 10/1/2018.
 */

@Singleton
public class TestRepoService implements RepoService {

    private boolean sendError;
    private final TestUtils testUtils;

    @Inject
    TestRepoService(TestUtils testUtils) {
        this.testUtils = testUtils;
    }

    @Override
    public Single<TrendingReposResponse> getTrendingRepos() {
        if(!sendError) {
            TrendingReposResponse response = testUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
            return Single.just(response);
        }
        return Single.error(new IOException());
    }

    @Override
    public Single<Repo> getRepo(String repoOwner, String repoName) {
        return null;
    }

    public void setSendError(boolean sendError) {
        this.sendError = sendError;
    }
}
