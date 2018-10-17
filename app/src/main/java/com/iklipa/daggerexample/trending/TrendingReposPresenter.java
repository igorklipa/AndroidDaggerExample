package com.iklipa.daggerexample.trending;

import com.iklipa.daggerexample.data.RepoRepository;
import com.iklipa.daggerexample.data.RepoRequester;
import com.iklipa.daggerexample.di.ScreenScope;
import com.iklipa.daggerexample.models.Repo;

import javax.inject.Inject;

/**
 * Created by iklipa on 9/14/2018.
 */

@ScreenScope
class TrendingReposPresenter implements RepoAdapter.RepoClickedListener {

    private final TrendingReposViewModel viewModel;
    private final RepoRepository repoRepository;

    @Inject
    TrendingReposPresenter(TrendingReposViewModel viewModel, RepoRepository repoRepository) {
        this.viewModel = viewModel;
        this.repoRepository = repoRepository;
        loadRepos();
    }

    private void loadRepos() {
        repoRepository.getTrendingRepos()
                .doOnSubscribe(__ -> viewModel.loadingUpdated().accept(true))
                .doOnEvent((d, t) -> viewModel.loadingUpdated().accept(false))
                .subscribe(viewModel.reposUpdated(), viewModel.onError());
    }

    @Override
    public void onRepoClicked(Repo repo) {
        // TODO
    }
}
