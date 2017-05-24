package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.NewsMultiListAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.news.newslist.NewsListFragment;
import com.jy.jyjy.module.news.newslist.NewsListPresenter;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/23.
 * 新闻列表 Module
 */
@Module
public class NewsListModule {
    private final NewsListFragment mNewsListView;
    private final String mNewsId;
    public NewsListModule(NewsListFragment view, String newsId) {
        this.mNewsListView = view;
        this.mNewsId = newsId;
    }
    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new NewsListPresenter(mNewsListView, mNewsId);
    }
    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new NewsMultiListAdapter(mNewsListView.getContext());
    }
}
