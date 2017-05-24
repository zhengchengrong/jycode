package com.jy.jyjy.module.manage.love.photo;

import com.jy.jyjy.local.table.BeautyPhotoInfo;
import com.jy.jyjy.local.table.BeautyPhotoInfoDao;
import com.jy.jyjy.module.base.ILocalPresenter;
import com.jy.jyjy.module.base.ILocalView;
import com.jy.jyjy.rxbus.RxBus;
import com.jy.jyjy.rxbus.event.LoveEvent;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by long on 2016/9/28.
 * 收藏 Presenter
 */
public class LovePhotoPresenter implements ILocalPresenter<BeautyPhotoInfo> {

    private final ILocalView mView;
    private final BeautyPhotoInfoDao mDbDao;
    private final RxBus mRxBus;

    public LovePhotoPresenter(ILocalView view, BeautyPhotoInfoDao dbDao, RxBus rxBus) {
        mView = view;
        mDbDao = dbDao;
        mRxBus = rxBus;
    }

    @Override
    public void getData(boolean isRefresh) {
        mDbDao.queryBuilder().where(BeautyPhotoInfoDao.Properties.IsLove.eq(true))
                .rx()
                .list()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<List<BeautyPhotoInfo>>() {
                    @Override
                    public void call(List<BeautyPhotoInfo> list) {
                        if (list.size() == 0) {
                            mView.noData();
                        } else {
                            mView.loadData(list);
                        }
                    }
                });
    }

    @Override
    public void getMoreData() {
    }

    @Override
    public void insert(BeautyPhotoInfo data) {
    }

    @Override
    public void delete(BeautyPhotoInfo data) {
        data.setLove(false);
        if (!data.isLove() && !data.isDownload() && !data.isPraise()) {
            mDbDao.delete(data);
        } else {
            mDbDao.update(data);
        }
        if (mDbDao.queryBuilder().where(BeautyPhotoInfoDao.Properties.IsLove.eq(true)).count() == 0) {
            // 如果收藏为0则显示无收藏
            mView.noData();
        }
        mRxBus.post(new LoveEvent());
    }

    @Override
    public void update(List<BeautyPhotoInfo> list) {
    }
}
