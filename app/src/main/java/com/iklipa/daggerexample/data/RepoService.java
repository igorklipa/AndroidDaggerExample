package com.iklipa.daggerexample.data;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by iklipa on 9/11/2018.
 */

public interface RepoService {

    @GET("search/repositories?q=language:java&order=desc&sort=stars")
    Single<TrendingReposResponse> getTrendingRepos();
}
