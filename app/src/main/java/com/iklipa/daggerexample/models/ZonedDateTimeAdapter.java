package com.iklipa.daggerexample.models;

import com.squareup.moshi.FromJson;
import com.squareup.moshi.ToJson;

import org.threeten.bp.ZonedDateTime;

import javax.annotation.Nullable;

/**
 * Created by iklipa on 9/10/2018.
 */

public class ZonedDateTimeAdapter {

    @FromJson
    ZonedDateTime fromJson(String json) {
        return ZonedDateTime.parse(json);
    }

    @ToJson
    String toJson(@Nullable ZonedDateTime value) {
        return value != null ? value.toString() : null;
    }
}
