package com.jy.jyjy.injector.components;

import android.app.Activity;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.ActivityModule;

import dagger.Component;

/**
 * Created by long on 2016/8/19.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    Activity getActivity();
}
