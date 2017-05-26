package com.jy.jyjy.injector.modules;

import android.content.Context;

import com.jy.jyjy.AndroidApplication;
import com.jy.jyjy.api.bean.Student;
import com.jy.jyjy.local.table.DaoSession;
import com.jy.jyjy.rxbus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by long on 2016/8/19.
 * Application Module
 */
@Module
public class ApplicationModule {

    private final AndroidApplication mApplication;
    private final DaoSession mDaoSession;
    private final RxBus mRxBus;

    private static int count = 0;

    public ApplicationModule(AndroidApplication application, DaoSession daoSession, RxBus rxBus) {
        mApplication = application;
        mDaoSession = daoSession;
        mRxBus = rxBus;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication.getContext();
    }

    @Provides
    @Singleton
    RxBus provideRxBus() {
        return mRxBus;
    }

    @Provides
    @Singleton
    DaoSession provideDaoSession() {
        return mDaoSession;
    }

    @Provides
    @Singleton
    Student providerStudent() {
        return new Student(23, "jack" + String.valueOf(count++));
    }

    @Provides
    @Singleton
    Context providerApplicationContext() {
        return mApplication.getContext();
    }

}
