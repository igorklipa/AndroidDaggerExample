package com.iklipa.daggerexample.trending;

import com.iklipa.daggerexample.R;
import com.iklipa.daggerexample.data.TrendingReposResponse;
import com.iklipa.daggerexample.testUtils.TestUtils;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import io.reactivex.observers.TestObserver;

import static org.junit.Assert.*;

/**
 * Created by iklipa on 10/1/2018.
 */
public class TrendingReposViewModelTest {
    TrendingReposViewModel viewModel;
    @Before
    public void setUp() throws Exception {
        viewModel = new TrendingReposViewModel();
    }

    @Test
    public void loading() throws Exception {
        TestObserver<Boolean> loadingObservable = viewModel.loading().test();
        viewModel.loadingUpdated().accept(true);
        viewModel.loadingUpdated().accept(false);

        loadingObservable.assertValues(true, false);
    }

    @Test
    public void repos() throws Exception {
        TrendingReposResponse reponse = TestUtils.loadJson("mock/get_trending_repos.json", TrendingReposResponse.class);
        viewModel.reposUpdated().accept(reponse.repos());
        viewModel.repos().test().assertValue(reponse.repos());
    }

    @Test
    public void error() throws Exception {
        TestObserver<Integer> errorObserver = viewModel.error().test();
        viewModel.onError().accept(new IOException());
        viewModel.reposUpdated().accept(Collections.emptyList());

        errorObserver.assertValues(R.string.api_error_repos, -1);
    }

}