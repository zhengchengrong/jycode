package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.BeautyListModule;
import com.jy.jyjy.module.photo.beauty.BeautyListFragment;

import dagger.Component;

/**
 * Created by long on 2016/9/5.
 * 美图 PerFragment
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = BeautyListModule.class)
public interface BeautyListComponent {
    void inject(BeautyListFragment fragment);
}
