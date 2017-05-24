package com.jy.jyjy.module.photo.welfare;

import android.support.v7.widget.RecyclerView;

import com.jy.jyjy.R;
import com.jy.jyjy.adapter.SlideInBottomAdapter;
import com.jy.jyjy.api.bean.WelfarePhotoInfo;
import com.jy.jyjy.injector.components.DaggerWelfarePhotoComponent;
import com.jy.jyjy.injector.modules.WelfarePhotoModule;
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
 * Created by long on 2016/10/11.
 * 福利图片界面
 */
public class WelfareListFragment extends BaseFragment<IBasePresenter> implements ILoadDataView<List<WelfarePhotoInfo>> {

    @BindView(R.id.rv_photo_list)
    RecyclerView mRvPhotoList;

    @Inject
    BaseQuickAdapter mAdapter;


    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_photo_list;
    }

    @Override
    protected void initInjector() {
        DaggerWelfarePhotoComponent.builder()
                .applicationComponent(getAppComponent())
                .welfarePhotoModule(new WelfarePhotoModule(this))
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
    public void loadData(List<WelfarePhotoInfo> photoList) {
        mAdapter.updateItems(photoList);
    }

    @Override
    public void loadMoreData(List<WelfarePhotoInfo> photoList) {
        mAdapter.loadComplete();
        mAdapter.addItems(photoList);
    }

    @Override
    public void loadNoData() {
        mAdapter.loadAbnormal();
    }
}