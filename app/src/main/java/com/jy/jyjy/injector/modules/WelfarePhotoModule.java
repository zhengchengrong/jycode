package com.jy.jyjy.injector.modules;

import com.jy.jyjy.adapter.WelfarePhotoAdapter;
import com.jy.jyjy.injector.PerFragment;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.photo.welfare.WelfareListFragment;
import com.jy.jyjy.module.photo.welfare.WelfareListPresenter;
import com.jy.recycler.adapter.BaseQuickAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/10/11.
 * 福利图片界面 Module
 */
@Module
public class WelfarePhotoModule {

    private final WelfareListFragment mView;

    public WelfarePhotoModule(WelfareListFragment view) {
        this.mView = view;
    }

    @PerFragment
    @Provides
    public IBasePresenter providePresenter() {
        return new WelfareListPresenter(mView);
    }

    @PerFragment
    @Provides
    public BaseQuickAdapter provideAdapter() {
        return new WelfarePhotoAdapter(mView.getContext());
    }
}
