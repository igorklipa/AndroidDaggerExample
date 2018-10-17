package com.iklipa.daggerexample.data;

import com.iklipa.daggerexample.models.Contributer;
import com.iklipa.daggerexample.models.Repo;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by iklipa on 9/11/2018.
 */

public class RepoRequester {

    private final RepoService repoService;

    @Inject
    RepoRequester(RepoService repoService) {
        this.repoService = repoService;
    }

    Single<List<Repo>> getTrendingRepos() {
        return repoService.getTrendingRepos()
                .map(TrendingReposResponse::repos);
    }

    Single<Repo> getRepo(String repoOwner, String repoName) {
        return repoService.getRepo(repoOwner, repoName);
    }

    Single<List<Contributer>> getContributors(String url) {
        return repoService.getContributors(url);
    }
}
