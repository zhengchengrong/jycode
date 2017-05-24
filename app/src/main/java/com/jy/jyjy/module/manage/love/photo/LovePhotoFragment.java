package com.jy.jyjy.module.manage.love.photo;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.jy.jyjy.R;
import com.jy.jyjy.adapter.SlideInBottomAdapter;
import com.jy.jyjy.injector.components.DaggerLovePhotoComponent;
import com.jy.jyjy.injector.modules.LovePhotoModule;
import com.jy.jyjy.local.table.BeautyPhotoInfo;
import com.jy.jyjy.module.base.BaseFragment;
import com.jy.jyjy.module.base.ILocalPresenter;
import com.jy.jyjy.module.base.ILocalView;
import com.jy.jyjy.utils.CommonConstant;
import com.jy.jyjy.utils.DialogHelper;
import com.jy.recycler.adapter.BaseQuickAdapter;
import com.jy.recycler.helper.RecyclerViewHelper;
import com.jy.recycler.listener.OnRecyclerViewItemLongClickListener;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import jp.wasabeef.recyclerview.animators.FlipInLeftYAnimator;

import static android.app.Activity.RESULT_OK;

/**
 * Created by long on 2016/12/13.
 * 图片收藏界面
 */
public class LovePhotoFragment extends BaseFragment<ILocalPresenter> implements ILocalView<BeautyPhotoInfo> {

    @BindView(R.id.rv_love_list)
    RecyclerView mRvPhotoList;
    @BindView(R.id.default_bg)
    TextView mDefaultBg;

    @Inject
    BaseQuickAdapter mAdapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.fragment_love_list;
    }

    @Override
    protected void initInjector() {
        DaggerLovePhotoComponent.builder()
                .applicationComponent(getAppComponent())
                .lovePhotoModule(new LovePhotoModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected void initViews() {
        SlideInBottomAdapter slideAdapter = new SlideInBottomAdapter(mAdapter);
        RecyclerViewHelper.initRecyclerViewSV(mContext, mRvPhotoList, slideAdapter, 2);
        mRvPhotoList.setItemAnimator(new FlipInLeftYAnimator());
        mAdapter.setOnItemLongClickListener(new OnRecyclerViewItemLongClickListener() {
            @Override
            public boolean onItemLongClick(View view, final int position) {
                DialogHelper.deleteDialog(mContext, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mPresenter.delete(mAdapter.getItem(position));
                        mAdapter.removeItem(position);
                    }
                });
                return true;
            }
        });
    }

    @Override
    protected void updateViews(boolean isRefresh) {
        mPresenter.getData(isRefresh);
    }

    @Override
    public void loadData(List<BeautyPhotoInfo> photoList) {
        if (mDefaultBg.getVisibility() == View.VISIBLE) {
            mDefaultBg.setVisibility(View.GONE);
        }
        mAdapter.updateItems(photoList);
    }

    @Override
    public void noData() {
        mDefaultBg.setVisibility(View.VISIBLE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CommonConstant.REQUEST_CODE && resultCode == RESULT_OK) {
            final boolean[] delLove = data.getBooleanArrayExtra(CommonConstant.RESULT_KEY);
            // 延迟 500MS 做删除操作，不然退回来看不到动画效果
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    for (int i = delLove.length - 1; i >= 0; i--) {
                        if (delLove[i]) {
                            mAdapter.removeItem(i);
                        }
                    }
                }
            }, 500);
        }
    }
}
