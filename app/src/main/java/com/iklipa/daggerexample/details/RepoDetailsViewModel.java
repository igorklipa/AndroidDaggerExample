package com.iklipa.daggerexample.details;

import com.iklipa.daggerexample.R;
import com.iklipa.daggerexample.di.ScreenScope;
import com.iklipa.daggerexample.models.Contributer;
import com.iklipa.daggerexample.models.Repo;
import com.jakewharton.rxrelay2.BehaviorRelay;

import org.threeten.bp.format.DateTimeFormatter;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import timber.log.Timber;

/**
 * Created by iklipa on 10/17/2018.
 */

@ScreenScope
public class RepoDetailsViewModel {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MMM dd, yyyy");

    private final BehaviorRelay<RepoDetailsState> detailStateRelay = BehaviorRelay.create();
    private final BehaviorRelay<ContributorState> contributorStateRelay = BehaviorRelay.create();

    @Inject
    RepoDetailsViewModel() {
        detailStateRelay.accept(RepoDetailsState.builder().loading(true).build());
        contributorStateRelay.accept(ContributorState.builder().loading(true).build());
    }

    Observable<RepoDetailsState> details() {
        return detailStateRelay;
    }

    Observable<ContributorState> contributors() {
        return contributorStateRelay;
    }

    Consumer<Repo> processRepo() {
        return repo -> {
            detailStateRelay.accept(
                    RepoDetailsState.builder()
                            .loading(false)
                            .name(repo.name())
                            .description(repo.description())
                            .createDate(repo.createdAt().format(DATE_FORMATTER))
                            .updateDate(repo.updatedAt().format(DATE_FORMATTER))
                            .build()
            );
        };
    }

    Consumer<List<Contributer>> proccessContributors() {
        return contributers -> contributorStateRelay.accept(
                ContributorState.builder()
                        .loading(false)
                        .contributors(contributers)
                        .build()
        );
    }

    Consumer<Throwable> detailsError() {
        return throwable -> {
            Timber.e(throwable, "Error loading repo details");
            detailStateRelay.accept(
                    RepoDetailsState.builder()
                            .loading(false)
                            .errorRes(R.string.api_error_single_repo)
                            .build()
            );
        };
    }

    Consumer<Throwable> contributorsError() {
        return throwable -> {
            Timber.e(throwable, "Error loading contributors");
            contributorStateRelay.accept(
                    ContributorState.builder()
                            .loading(false)
                            .errorRes(R.string.api_error_contributors)
                            .build()
            );
        };
    }
}
