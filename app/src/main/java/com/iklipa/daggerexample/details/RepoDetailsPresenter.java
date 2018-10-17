package com.iklipa.daggerexample.details;

import com.iklipa.daggerexample.data.RepoRepository;
import com.iklipa.daggerexample.di.ScreenScope;

import javax.inject.Inject;
import javax.inject.Named;

import static com.iklipa.daggerexample.details.RepoDetailsController.REPO_NAME_KEY;
import static com.iklipa.daggerexample.details.RepoDetailsController.REPO_OWNER_KEY;

/**
 * Created by iklipa on 10/17/2018.
 */

@ScreenScope
public class RepoDetailsPresenter {

    @Inject
    RepoDetailsPresenter(@Named(REPO_OWNER_KEY) String repoOwner,
                         @Named(REPO_NAME_KEY) String repoName,
                         RepoRepository repoRepository,
                         RepoDetailsViewModel viewModel) {
        repoRepository.getRepo(repoOwner, repoName)
                .doOnSuccess(viewModel.processRepo())
                .doOnError(viewModel.detailsError())
                .flatMap(repo -> repoRepository.getContributors(repo.contributorsUrl()))
                    .doOnError(viewModel.contributorsError())
                .subscribe(viewModel.proccessContributors(), throwable -> {
                    // We handle logging in the view model
                });
    }
}
