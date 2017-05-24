package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.PhotoNewsModule;
import com.jy.jyjy.module.photo.news.PhotoNewsFragment;

import dagger.Component;

/**
 * Created by long on 2016/9/5.
 * 图片新闻列表 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = PhotoNewsModule.class)
public interface PhotoNewsComponent {
    void inject(PhotoNewsFragment fragment);
}
