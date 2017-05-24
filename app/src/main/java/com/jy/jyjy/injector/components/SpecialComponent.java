package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.SpecialModule;
import com.jy.jyjy.module.news.special.SpecialActivity;

import dagger.Component;

/**
 * Created by long on 2016/8/26.
 * 专题 Component
 */
@PerActivity
@Component(modules = SpecialModule.class)
public interface SpecialComponent {
    void inject(SpecialActivity activity);
}
