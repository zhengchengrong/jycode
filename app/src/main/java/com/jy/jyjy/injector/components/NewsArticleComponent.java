package com.jy.jyjy.injector.components;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.injector.modules.NewsArticleModule;
import com.jy.jyjy.module.news.article.NewsArticleActivity;

import dagger.Component;

/**
 * Created by long on 2017/2/3.
 * 新闻详情 Component
 */
@PerActivity
@Component(modules = NewsArticleModule.class)
public interface NewsArticleComponent {
    void inject(NewsArticleActivity activity);
}
