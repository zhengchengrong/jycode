package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.VideoListAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.video.list.VideoListFragment;
import com.jy.jyjy.module.video.list.VideoListPresenter;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/10/11.
 * video列表
 */
@Module
public class VideoListModule {

    private final VideoListFragment mView;
    private final String mVideoId;

    public VideoListModule(VideoListFragment view, String videoId) {
        this.mView = view;
        this.mVideoId = videoId;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new VideoListPresenter(mView, mVideoId);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new VideoListAdapter(mView.getContext());
    }
}
