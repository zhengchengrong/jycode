package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.ViewPagerAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.IRxBusPresenter;
import com.jy.jyjy.module.video.main.VideoMainFragment;
import com.jy.jyjy.module.video.main.VideoMainPresenter;
import com.jy.jyjy.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/20.
 * 视频主界面 Module
 */
@Module
public class VideoMainModule {

    private final VideoMainFragment mView;

    public VideoMainModule(VideoMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }

    @PerFragment
    @Provides
    public IRxBusPresenter provideVideosPresenter(DaoSession daoSession, RxBus rxBus) {
        return new VideoMainPresenter(mView, daoSession.getVideoInfoDao(), rxBus);
    }
}
