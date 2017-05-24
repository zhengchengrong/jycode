package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.VideoListModule;
import com.jy.jyjy.module.video.list.VideoListFragment;

import dagger.Component;

/**
 * Created by long on 2016/10/11.
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = VideoListModule.class)
public interface VideoListComponent {
    void inject(VideoListFragment fragment);
}
