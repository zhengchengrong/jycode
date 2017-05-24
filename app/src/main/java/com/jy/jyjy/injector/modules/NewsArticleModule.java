package com.jy.jyjy.injector.modules;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.news.article.NewsArticleActivity;
import com.jy.jyjy.module.news.article.NewsArticlePresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2017/2/3.
 * 新闻详情 Module
 */
@Module
public class NewsArticleModule {

    private final String mNewsId;
    private final NewsArticleActivity mView;

    public NewsArticleModule(NewsArticleActivity view, String newsId) {
        mNewsId = newsId;
        mView = view;
    }

    @PerActivity
    @Provides
    public IBasePresenter providePresenter() {
        return new NewsArticlePresenter(mNewsId, mView);
    }

}
