package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.LoveVideoModule;
import com.jy.jyjy.module.manage.love.video.LoveVideoFragment;

import dagger.Component;

/**
 * Created by long on 2016/12/13.
 * Video收藏 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = LoveVideoModule.class)
public interface LoveVideoComponent {
    void inject(LoveVideoFragment fragment);
}
