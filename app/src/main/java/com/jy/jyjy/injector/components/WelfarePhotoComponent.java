package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.WelfarePhotoModule;
import com.jy.jyjy.module.photo.welfare.WelfareListFragment;

import dagger.Component;

/**
 * Created by long on 2016/10/11.
 * 福利图片界面 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = WelfarePhotoModule.class)
public interface WelfarePhotoComponent {
    void inject(WelfareListFragment fragment);
}
