package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.NewsDetailModule;
import com.jy.jyjy.module.news.detail.NewsDetailActivity;

import dagger.Component;

/**
 * Created by long on 2016/8/25.
 * 新闻详情 Component
 */
@Deprecated
@PerActivity
@Component(modules = NewsDetailModule.class)
public interface NewsDetailComponent {
    void inject(NewsDetailActivity activity);
}
