package com.jy.jyjy.injector.components;

import com.jy.jyjy.HomeActivity;
import com.jy.jyjy.TestActivity;
import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.ConstructorModule;

import dagger.Component;

/**
 * Created by zcr on 2017/5/26.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ConstructorModule.class)
public interface ConstructorComponent {
    void inject(TestActivity mainActivity);
}
