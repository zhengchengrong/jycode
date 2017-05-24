package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.LovePhotoModule;
import com.jy.jyjy.module.manage.love.photo.LovePhotoFragment;

import dagger.Component;

/**
 * Created by long on 2016/12/13.
 * 图片收藏界面 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = LovePhotoModule.class)
public interface LovePhotoComponent {
    void inject(LovePhotoFragment fragment);
}
