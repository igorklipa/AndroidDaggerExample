package com.iklipa.daggerexample.details;

import com.iklipa.daggerexample.di.ScreenScope;

import javax.inject.Named;

import dagger.BindsInstance;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

import static com.iklipa.daggerexample.details.RepoDetailsController.REPO_NAME_KEY;
import static com.iklipa.daggerexample.details.RepoDetailsController.REPO_OWNER_KEY;

/**
 * Created by iklipa on 10/17/2018.
 */

@ScreenScope
@Subcomponent
public interface RepoDetailsComponent extends AndroidInjector<RepoDetailsController> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<RepoDetailsController> {

        @BindsInstance
        public abstract void bindRepoOwner(@Named(REPO_OWNER_KEY) String repoOwner);

        @BindsInstance
        public abstract void bindRepoName(@Named(REPO_NAME_KEY) String repoName);

        @Override
        public void seedInstance(RepoDetailsController instance) {
            bindRepoName(instance.getArgs().getString(REPO_NAME_KEY));
            bindRepoOwner(instance.getArgs().getString(REPO_OWNER_KEY));
        }
    }
}
