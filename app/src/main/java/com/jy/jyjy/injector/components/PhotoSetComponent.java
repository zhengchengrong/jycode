package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.PhotoSetModule;
import com.jy.jyjy.module.news.photoset.PhotoSetActivity;

import dagger.Component;

/**
 * Created by long on 2016/8/29.
 * 图集 Component
 */
@PerActivity
@Component(modules = PhotoSetModule.class)
public interface PhotoSetComponent {
    void inject(PhotoSetActivity activity);
}
