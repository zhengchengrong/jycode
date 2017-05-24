package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.BaseVideoDLAdapter;
import com.jy.jyjy.adapter.VideoCompleteAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.IRxBusPresenter;
import com.jy.jyjy.module.manage.download.complete.VideoCompleteFragment;
import com.jy.jyjy.module.manage.download.complete.VideoCompletePresenter;
import com.jy.jyjy.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/16.
 * video 缓存完成 Module
 */
@Module
public class VideoCompleteModule {

    private final VideoCompleteFragment mView;

    public VideoCompleteModule(VideoCompleteFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public IRxBusPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new VideoCompletePresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseVideoDLAdapter provideAdapter(RxBus rxBus) {
        return new VideoCompleteAdapter(mView.getContext(), rxBus);
    }
}
