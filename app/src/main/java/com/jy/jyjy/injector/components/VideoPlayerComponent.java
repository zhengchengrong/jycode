package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.VideoPlayerModule;
import com.jy.jyjy.module.video.player.VideoPlayerActivity;

import dagger.Component;

/**
 * Created by long on 2016/11/30.
 * Video Component
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = VideoPlayerModule.class)
public interface VideoPlayerComponent {
    void inject(VideoPlayerActivity activity);
}
