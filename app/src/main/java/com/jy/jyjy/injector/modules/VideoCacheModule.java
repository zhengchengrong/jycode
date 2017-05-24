package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.BaseVideoDLAdapter;
import com.jy.jyjy.adapter.VideoCacheAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.IRxBusPresenter;
import com.jy.jyjy.module.manage.download.cache.VideoCacheFragment;
import com.jy.jyjy.module.manage.download.cache.VideoCachePresenter;
import com.jy.jyjy.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/16.
 * video缓存Module
 */
@Module
public class VideoCacheModule {

    private final VideoCacheFragment mView;

    public VideoCacheModule(VideoCacheFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new VideoCachePresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseVideoDLAdapter provideAdapter(RxBus rxBus) {
        return new VideoCacheAdapter(mView.getContext(), rxBus);
    }
}
