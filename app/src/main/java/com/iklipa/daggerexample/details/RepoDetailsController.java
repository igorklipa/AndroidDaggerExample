package com.iklipa.daggerexample.details;

import android.os.Bundle;

import com.bluelinelabs.conductor.Controller;
import com.iklipa.daggerexample.R;
import com.iklipa.daggerexample.base.BaseController;

import javax.inject.Inject;

/**
 * Created by iklipa on 10/17/2018.
 */

public class RepoDetailsController extends BaseController {

    static final String REPO_NAME_KEY = "repo_name";
    static final String REPO_OWNER_KEY = "repo_owner";

    public static Controller newInstance(String repoName, String repoOwner) {
        Bundle bundle = new Bundle();
        bundle.putString(REPO_NAME_KEY, repoName);
        bundle.putString(REPO_OWNER_KEY, repoOwner);
        return new RepoDetailsController(bundle);
    }

    public RepoDetailsController(Bundle bundle) {
        super(bundle);
    }

    @Override
    protected int layoutRes() {
        return R.layout.screen_repo_details;
    }
}
