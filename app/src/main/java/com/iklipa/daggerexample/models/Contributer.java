package com.iklipa.daggerexample.models;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

/**
 * Created by iklipa on 9/10/2018.
 */

@AutoValue
public abstract class Contributer {

    public abstract long id();

    public abstract String login();

    @Json(name = "avatar_url")
    public abstract String avatarUrl();

    public static JsonAdapter<Contributer> jsonAdapter(Moshi moshi) {
        return new AutoValue_Contributer.MoshiJsonAdapter(moshi);
    }
}
