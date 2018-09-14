package com.iklipa.daggerexample.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bluelinelabs.conductor.Controller;
import com.iklipa.daggerexample.di.Injector;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by iklipa on 9/7/2018.
 */

public abstract class BaseController extends Controller {

    private final CompositeDisposable disposables = new CompositeDisposable();
    private boolean injected = false;
    private Unbinder unbinder;

    protected void onContextAvailable(@NonNull Context context) {
        // Controller instances are retained across config changes, so this method can be called more than once. This makes
        // sure we don't waste any time injecting more than once, though technically it wouldn't change functionality.
        if (!injected) {
            Injector.inject(this);
            injected = true;
        }
        super.onContextAvailable(context);
    }

    @NonNull
    @Override
    protected final View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup container) {
        View view = inflater.inflate(layoutRes(), container, false);
        unbinder = ButterKnife.bind(this, view);
        onViewBound(view);
        disposables.addAll(subscriptions());
        return view;
    }

    protected void onViewBound(@NonNull View view) {

    }

    protected Disposable[] subscriptions() {
        return new Disposable[0];
    }

    @LayoutRes
    protected abstract int layoutRes();

    @Override
    protected void onDestroyView(@NonNull View view) {
        super.onDestroyView(view);
        disposables.clear();
        if(unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
    }
}
