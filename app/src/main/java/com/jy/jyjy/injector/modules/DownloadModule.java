package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.ViewPagerAdapter;
import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.module.base.IRxBusPresenter;
import com.jy.jyjy.module.manage.download.DownloadActivity;
import com.jy.jyjy.module.manage.download.DownloadPresenter;
import com.jy.jyjy.rxbus.RxBus;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/12/19.
 * video下载Module
 */
@Module
public class DownloadModule {

    private final DownloadActivity mView;

    public DownloadModule(DownloadActivity view) {
        mView = view;
    }

    @PerActivity
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getSupportFragmentManager());
    }

    @PerActivity
    @Provides
    public IRxBusPresenter provideVideosPresenter(RxBus rxBus) {
        return new DownloadPresenter(rxBus);
    }
}
