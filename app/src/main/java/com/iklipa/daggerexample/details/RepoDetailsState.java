package com.iklipa.daggerexample.details;

import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

/**
 * Created by iklipa on 10/17/2018.
 */

@AutoValue
public abstract class RepoDetailsState {

    abstract boolean loading();

    @Nullable
    abstract String name();

    @Nullable
    abstract String description();

    @Nullable
    abstract String createDate();

    @Nullable
    abstract String updateDate();

    @Nullable
    abstract Integer errorRes();

    static Builder builder() {
        return new AutoValue_RepoDetailsState.Builder();
    }

    @AutoValue.Builder
    abstract static class Builder {

        abstract Builder loading(boolean loading);

        abstract Builder name(String name);

        abstract Builder description(String description);

        abstract Builder createDate(String createDate);

        abstract Builder updateDate(String updateDate);

        abstract Builder errorRes(Integer errorRes);

        abstract RepoDetailsState build();
    }
}
