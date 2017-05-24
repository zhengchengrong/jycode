package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.VideoCompleteModule;
import com.jy.jyjy.module.manage.download.complete.VideoCompleteFragment;

import dagger.Component;

/**
 * Created by long on 2016/12/16.
 * video 缓存完成 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoCompleteModule.class)
public interface VideoCompleteComponent {
    void inject(VideoCompleteFragment fragment);
}
