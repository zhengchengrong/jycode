package com.jy.jyjy.injector.components;

import android.app.Application;

import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.injector.modules.InspectMainModule;
import com.jy.jyjy.injector.modules.NewsListModule;
import com.jy.jyjy.module.inspect.main.InspectMainFragment;
import com.jy.jyjy.module.news.newslist.NewsListFragment;

import dagger.Component;

/**
 * Created by long on 2016/8/23.
 * 新闻列表 Component
 */
@PerFragment
@Component(dependencies = ApplicationComponent.class, modules = InspectMainModule.class)
public interface InspectMainComponent{
    void inject(InspectMainFragment fragment);
}
