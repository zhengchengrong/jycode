package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.VideoCacheModule;
import com.jy.jyjy.module.manage.download.cache.VideoCacheFragment;

import dagger.Component;

/**
 * Created by long on 2016/12/16.
 * video缓存Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoCacheModule.class)
public interface VideoCacheComponent {
    void inject(VideoCacheFragment fragment);
}
