package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.SpecialAdapter;
import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.news.special.SpecialActivity;
import com.jy.jyjy.module.news.special.SpecialPresenter;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/26.
 * 专题 Module
 */
@Module
public class SpecialModule {

    private final SpecialActivity mView;
    private final String mSpecialId;

    public SpecialModule(SpecialActivity view, String specialId) {
        mView = view;
        mSpecialId = specialId;
    }

    @PerActivity
    @Provides
    public IBasePresenter provideSpecialPresent() {
        return new SpecialPresenter(mView, mSpecialId);
    }

    @PerActivity
    @Provides
    public BaseQuickAdapter provideSpecialAdapter() {
        return new SpecialAdapter(mView);
    }
}
