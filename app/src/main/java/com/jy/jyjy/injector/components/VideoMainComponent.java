package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.VideoMainModule;
import com.jy.jyjy.module.video.main.VideoMainFragment;

import dagger.Component;

/**
 * Created by long on 2016/12/20.
 * 视频主界面 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoMainModule.class)
public interface VideoMainComponent {
    void inject(VideoMainFragment fragment);
}
