package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.PhotoMainModule;
import com.jy.jyjy.module.photo.main.PhotoMainFragment;

import dagger.Component;

/**
 * Created by long on 2016/12/20.
 * 图片 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = PhotoMainModule.class)
public interface PhotoMainComponent {
    void inject(PhotoMainFragment fragment);
}
