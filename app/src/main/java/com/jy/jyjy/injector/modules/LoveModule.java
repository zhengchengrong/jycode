package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.ViewPagerAdapter;
import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.module.manage.love.LoveActivity;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/9/28.
 * 收藏 Module
 */
@Module
public class LoveModule {

    private final LoveActivity mView;

    public LoveModule(LoveActivity view) {
        this.mView = view;
    }

    @PerActivity
    @Provides
    public ViewPagerAdapter provideViewPagerAdapter() {
        return new ViewPagerAdapter(mView.getSupportFragmentManager());
    }

}
