package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.BigPhotoModule;
import com.jy.jyjy.module.photo.bigphoto.BigPhotoActivity;

import dagger.Component;

/**
 * Created by long on 2016/9/27.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = BigPhotoModule.class)
public interface BigPhotoComponent {
    void inject(BigPhotoActivity activity);
}
