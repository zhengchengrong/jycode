package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.ViewPagerAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.module.base.IRxBusPresenter;
import com.jy.jyjy.module.photo.main.PhotoMainFragment;
import com.jy.jyjy.module.photo.main.PhotoMainPresenter;
import com.jy.jyjy.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/20.
 * 图片主界面 Module
 */
@Module
public class PhotoMainModule {

    private final PhotoMainFragment mView;

    public PhotoMainModule(PhotoMainFragment view) {
        mView = view;
    }

    @PerFragment
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getChildFragmentManager());
    }

    @PerFragment
    @Provides
    public IRxBusPresenter providePhotosPresenter(DaoSession daoSession, RxBus rxBus) {
        return new PhotoMainPresenter(mView, daoSession.getBeautyPhotoInfoDao(), rxBus);
    }
}
