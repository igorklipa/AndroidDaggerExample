package com.iklipa.daggerexample.details;

import com.google.auto.value.AutoValue;
import com.iklipa.daggerexample.models.Contributer;

import java.util.List;

import javax.annotation.Nullable;

/**
 * Created by iklipa on 10/17/2018.
 */

@AutoValue
public abstract class ContributorState {

    abstract boolean loading();

    @Nullable
    abstract List<Contributer> contributors();

    @Nullable
    abstract Integer errorRes();

    static Builder builder() {
        return new AutoValue_ContributorState.Builder();
    }
    @AutoValue.Builder
    abstract static class Builder {
        abstract Builder loading(boolean loading);

        abstract Builder contributors(List<Contributer> contributors);

        abstract Builder errorRes(Integer errorRes);

        abstract ContributorState build();
    }
}
