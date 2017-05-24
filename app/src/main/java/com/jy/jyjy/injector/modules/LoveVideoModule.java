package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.VideoLoveAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.ILocalPresenter;
import com.jy.jyjy.module.manage.love.video.LoveVideoFragment;
import com.jy.jyjy.module.manage.love.video.LoveVideoPresenter;
import com.jy.jyjy.rxbus.RxBus;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/13.
 * Video收藏
 */
@Module
public class LoveVideoModule {

    private final LoveVideoFragment mView;

    public LoveVideoModule(LoveVideoFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public ILocalPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new LoveVideoPresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new VideoLoveAdapter(mView.getContext());
    }
}
