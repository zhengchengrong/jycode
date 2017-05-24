package com.jy.jyjy.module.photo.news;

import android.support.v7.widget.RecyclerView;

import com.jy.jyjy.R;
import com.jy.jyjy.api.bean.PhotoInfo;
import com.jy.jyjy.injector.components.DaggerPhotoNewsComponent;
import com.jy.jyjy.injector.modules.PhotoNewsModule;
import com.jy.jyjy.module.base.BaseFragment;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.base.ILoadDataView;
import com.jy.recycler.adapter.BaseQuickAdapter;
import com.jy.recycler.helper.RecyclerViewHelper;
import com.jy.recycler.listener.OnRequestDataListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.recyclerview.adapters.SlideInBottomAnimationAdapter;

/**
 * Created by long on 2016/9/5.
 * 图片新闻列表
 */
public class PhotoNewsFragment extends BaseFragment<IBasePresenter> implements ILoadDataView<List<PhotoInfo>> {

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
        DaggerPhotoNewsComponent.builder()
                .applicationComponent(getAppComponent())
                .photoNewsModule(new PhotoNewsModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        RecyclerViewHelper.initRecyclerViewV(mContext, mRvPhotoList, new SlideInBottomAnimationAdapter(mAdapter));
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
    public void loadData(List<PhotoInfo> photoList) {
        mAdapter.updateItems(photoList);
    }

    @Override
    public void loadMoreData(List<PhotoInfo> photoList) {
        mAdapter.addItems(photoList);
    }

    @Override
    public void loadNoData() {
        mAdapter.noMoreData();
    }
}
