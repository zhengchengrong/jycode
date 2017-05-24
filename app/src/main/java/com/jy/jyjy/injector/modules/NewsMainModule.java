package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.ViewPagerAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.IRxBusPresenter;
import com.jy.jyjy.module.news.main.NewsMainPresenter;
import com.jy.jyjy.module.news.main.NewsMainFragment;
import com.jy.jyjy.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/20.
 * 新闻主页 Module
 */
@Module
public class NewsMainModule {

    private final NewsMainFragment mView;

    public NewsMainModule(NewsMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter provideMainPresenter(DaoSession daoSession, RxBus rxBus) {
        return new NewsMainPresenter(mView, daoSession.getNewsTypeInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }
}
