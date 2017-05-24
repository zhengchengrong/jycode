package com.jy.jyjy.module.inspect.main;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jy.jyjy.R;
import com.jy.jyjy.local.table.NewsTypeInfo;
import com.jy.jyjy.module.base.BaseFragment;
import com.jy.jyjy.module.base.IRxBusPresenter;
import com.jy.jyjy.utils.ToastUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by zcr on 2017/5/24.
 */

public class InspectMainFragment extends BaseFragment<IRxBusPresenter> implements IInspectMainView, View.OnClickListener {

    @BindView(R.id.iv_inspect_nav)
    ImageView mIvInspectNav;

    @Override
    protected int attachLayoutRes() {
         return R.layout.fragment_inspeact_main;
    }

    @Override
    protected void initInjector() {

    }

    @Override
    protected void initViews() {
        mIvInspectNav.setOnClickListener(this);
    }

    @Override
    protected void updateViews(boolean isRefresh) {

    }

    @Override
    public void loadData(List<NewsTypeInfo> mainData) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_inspect_nav:
                ToastUtils.showToast("哎呀，我被点击了");
                break;
        }
    }
}
