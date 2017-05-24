package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.PhotoPagerAdapter;
import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.local.table.BeautyPhotoInfo;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.ILocalPresenter;
import com.jy.jyjy.module.photo.bigphoto.BigPhotoActivity;
import com.jy.jyjy.module.photo.bigphoto.BigPhotoPresenter;
import com.jy.jyjy.rxbus.RxBus;

import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/9/27.
 * 大图 Module
 */
@PerActivity
@Module
public class BigPhotoModule {
    private final BigPhotoActivity mView;
    private List<BeautyPhotoInfo> mPhotoList;
    public BigPhotoModule(BigPhotoActivity view, List<BeautyPhotoInfo> photoList) {
        this.mView = view;
        this.mPhotoList = photoList;
    }
    @PerActivity
    @Provides
    public ILocalPresenter providePresenter(DaoSession daoSession, RxBus rxBus) {
        return new BigPhotoPresenter(mView, daoSession.getBeautyPhotoInfoDao(), mPhotoList, rxBus);
    }
    @PerActivity
    @Provides
    public PhotoPagerAdapter provideAdapter() {
        return new PhotoPagerAdapter(mView);
    }

}
