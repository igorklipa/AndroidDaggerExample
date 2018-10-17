package com.iklipa.daggerexample.data;

import com.iklipa.daggerexample.models.Repo;
import com.iklipa.daggerexample.testUtils.TestUtils;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Provider;

import io.reactivex.Single;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Created by iklipa on 10/17/2018.
 */
public class RepoRepositoryTest {

    @Mock
    Provider<RepoRequester> repoRequesterProvider;
    @Mock
    RepoRequester repoRequester;

    private RepoRepository repoRepository;
    private TrendingReposResponse trendingReposResponse;
    private Repo rxJavaRepo;
    private Repo otherRepo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        when(repoRequesterProvider.get()).thenReturn(repoRequester);

        trendingReposResponse = TestUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(trendingReposResponse.repos()));

        rxJavaRepo = trendingReposResponse.repos().get(0);
        otherRepo = trendingReposResponse.repos().get(1);
        repoRepository = new RepoRepository(repoRequesterProvider);
    }

    @Test
    public void getTrendingRepos() throws Exception {
        repoRepository.getTrendingRepos().test().assertValue(trendingReposResponse.repos());

        List<Repo> modifiedList = new ArrayList<>(trendingReposResponse.repos());
        modifiedList.remove(0);
        when(repoRequester.getTrendingRepos()).thenReturn(Single.just(modifiedList));

        repoRepository.getTrendingRepos().test().assertValue(trendingReposResponse.repos());
    }

    @Test
    public void getRepo() throws Exception {
        repoRepository.getTrendingRepos().subscribe();

        when(repoRequester.getRepo(anyString(), anyString())).thenReturn(Single.just(otherRepo));

        repoRepository.getRepo("ReactiveX", "RxJava").test().assertValue(rxJavaRepo);

        repoRepository.getRepo("NotInCache", "NotInCache").test().assertValue(otherRepo);
    }

}