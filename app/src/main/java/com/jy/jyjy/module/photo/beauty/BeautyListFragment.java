package com.jy.jyjy.module.photo.beauty;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.jy.jyjy.R;
import com.jy.jyjy.adapter.SlideInBottomAdapter;
import com.jy.jyjy.injector.components.DaggerBeautyListComponent;
import com.jy.jyjy.injector.modules.BeautyListModule;
import com.jy.jyjy.local.table.BeautyPhotoInfo;
import com.jy.jyjy.module.base.BaseFragment;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.base.ILoadDataView;
import com.jy.recycler.adapter.BaseQuickAdapter;
import com.jy.recycler.helper.RecyclerViewHelper;
import com.jy.recycler.listener.OnRequestDataListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by long on 2016/9/5.
 * 美女图片
 */
public class BeautyListFragment extends BaseFragment<IBasePresenter> implements ILoadDataView<List<BeautyPhotoInfo>> {
    @BindView(R.id.rv_photo_list)
    RecyclerView mRvPhotoList;
    @BindView(R.id.iv_transition_photo)
    ImageView mIvTransitionPhoto;
    @Inject
    BaseQuickAdapter mAdapter;
    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_photo_list;
    }
    @Override
    protected void initInjector() {
        DaggerBeautyListComponent.builder()
                .applicationComponent(getAppComponent())
                .beautyListModule(new BeautyListModule(this))
                .build()
                .inject(this);
    }
    @Override
    protected void initViews() {
        SlideInBottomAdapter slideAdapter = new SlideInBottomAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewSV(mContext, mRvPhotoList, slideAdapter, 2);
        mAdapter.setRequestDataListener(new OnRequestDataListener() {
            @Override
            public void onLoadMore() {
                mPresenter.getMoreData();
            }
        });
    }
    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }
    @Override
    public void loadData(List<BeautyPhotoInfo> photoList) {
        mAdapter.updateItems(photoList);
    }
    @Override
    public void loadMoreData(List<BeautyPhotoInfo> photoList) {
        mAdapter.loadComplete();
        mAdapter.addItems(photoList);
    }
    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }
}
