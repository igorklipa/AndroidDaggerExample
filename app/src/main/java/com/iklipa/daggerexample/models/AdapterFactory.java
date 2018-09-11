package com.iklipa.daggerexample.models;

import com.ryanharter.auto.value.moshi.MoshiAdapterFactory;
import com.squareup.moshi.JsonAdapter;

/**
 * Created by iklipa on 9/10/2018.
 */

@MoshiAdapterFactory
public abstract class AdapterFactory implements JsonAdapter.Factory {

    public static JsonAdapter.Factory create() {
        return new AutoValueMoshi_AdapterFactory();
    }
}
