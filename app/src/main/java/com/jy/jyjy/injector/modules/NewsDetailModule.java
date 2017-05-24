package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.RelatedNewsAdapter;
import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.news.detail.NewsDetailActivity;
import com.jy.jyjy.module.news.detail.NewsDetailPresenter;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/25.
 * 新闻详情 Module
 */
@Deprecated
@Module
public class NewsDetailModule {

    private final String mNewsId;
    private final NewsDetailActivity mView;

    public NewsDetailModule(NewsDetailActivity view, String newsId) {
        mNewsId = newsId;
        mView = view;
    }

    @PerActivity
    @Provides
    public BaseQuickAdapter provideRelatedAdapter() {
        return new RelatedNewsAdapter(mView);
    }

    @PerActivity
    @Provides
    public IBasePresenter providePresenter() {
        return new NewsDetailPresenter(mNewsId, mView);
    }
}
