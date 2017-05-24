package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.BeautyPhotosAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.ILocalPresenter;
import com.jy.jyjy.module.manage.love.photo.LovePhotoPresenter;
import com.jy.jyjy.module.manage.love.photo.LovePhotoFragment;
import com.jy.jyjy.rxbus.RxBus;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/13.
 * 图片收藏界面 Module
 */
@Module
public class LovePhotoModule {

    private final LovePhotoFragment mView;

    public LovePhotoModule(LovePhotoFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public ILocalPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new LovePhotoPresenter(mView, daoSession.getBeautyPhotoInfoDao(), rxBus);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new BeautyPhotosAdapter(mView);
    }
}
