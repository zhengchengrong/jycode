package com.jy.jyjy.injector.modules;

import com.jy.jyjy.injector.PerActivity;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.news.photoset.PhotoSetActivity;
import com.jy.jyjy.module.news.photoset.PhotoSetPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/29.
 * 图集 Module
 */
@Module
public class PhotoSetModule {

    private final PhotoSetActivity mView;
    private final String mPhotoSetId;

    public PhotoSetModule(PhotoSetActivity view, String photoSetId) {
        mView = view;
        mPhotoSetId = photoSetId;
    }

    @PerActivity
    @Provides
    public IBasePresenter providePhotoSetPresenter() {
        return new PhotoSetPresenter(mView, mPhotoSetId);
    }
}
