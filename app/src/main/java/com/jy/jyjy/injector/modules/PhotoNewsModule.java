package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.PhotoListAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.photo.news.PhotoNewsFragment;
import com.jy.jyjy.module.photo.news.PhotoNewsPresenter;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/9/5.
 * 图片新闻列表 Module
 */
@Module
public class PhotoNewsModule {

    private final PhotoNewsFragment mView;

    public PhotoNewsModule(PhotoNewsFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new PhotoNewsPresenter(mView);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new PhotoListAdapter(mView.getContext());
    }
}
