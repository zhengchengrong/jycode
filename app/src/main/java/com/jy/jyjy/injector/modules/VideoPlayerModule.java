package com.jy.jyjy.injector.modules;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.local.table.VideoInfo;
import com.jy.jyjy.module.video.player.IVideoPresenter;
import com.jy.jyjy.module.video.player.VideoPlayerActivity;
import com.jy.jyjy.module.video.player.VideoPlayerPresenter;
import com.jy.jyjy.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/11/30.
 * Video Module
 */
@Module
public class VideoPlayerModule {

    private final VideoPlayerActivity mView;
    private final VideoInfo mVideoData;

    public VideoPlayerModule(VideoPlayerActivity view, VideoInfo videoData) {
        this.mView = view;
        this.mVideoData = videoData;
    }

    @PerActivity
    @Provides
    public IVideoPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new VideoPlayerPresenter(mView, daoSession.getVideoInfoDao(), rxBus, mVideoData, daoSession.getDanmakuInfoDao());
    }

}
