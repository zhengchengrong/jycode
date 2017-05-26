package com.jy.jyjy.module.inspect.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bartoszlipinski.recyclerviewheader2.RecyclerViewHeader;
import com.daimajia.slider.library.SliderLayout;
import com.jy.jyjy.R;
import com.jy.jyjy.adapter.item.NewsMultiItem;
import com.jy.jyjy.api.bean.NewsInfo;

import com.jy.jyjy.injector.components.DaggerInspectMainComponent;
import com.jy.jyjy.injector.modules.InspectMainModule;
import com.jy.jyjy.module.base.BaseFragment;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.utils.SliderHelper;
import com.jy.recycler.adapter.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * Created by zcr on 2017/5/24.
 */

public class InspectMainFragment extends BaseFragment<IBasePresenter> implements IInspectMainView{
    private static final String NEWS_TYPE_KEY = "NewsTypeKey";

    @BindView(R.id.rv_news_list)
    ListView mRvNewsList;


    public String mNewsId="T1348649079062";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    protected int attachLayoutRes() {
         return R.layout.fragment_inspeact_main;
    }

    @Override
    protected void initInjector() {

//        DaggerInspectMainComponent.builder().applicationComponent(AndroidApplication.getAppComponent())
//                .inspectMainModule(new InspectMainModule(this, mNewsId)).build();

//        DaggerInspectMainComponent.builder()
//                .applicationComponent(getAppComponent())
//                .inspectMainModule(new InspectMainModule(this, mNewsId))
//                .build()
//                .inject(this);
    }
    private List<String> mDatas;
    @Override
    protected void initViews() {
        //生成动态数组，并且转载数据
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        for(int i=0;i<30;i++)
        {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put("ItemTitle", "This is Title.....");
            map.put("ItemText", "This is text.....");
            mylist.add(map);
        }
        SimpleAdapter mSchedule = new SimpleAdapter(getContext(),
                mylist,
                R.layout.test,
                new String[] {"ItemTitle", "ItemText"},
                new int[] {R.id.ItemTitle,R.id.ItemText});
        mRvNewsList.setAdapter(mSchedule);

        View view = LayoutInflater.from(mContext).inflate(R.layout.fragment_inspeact_main_top, null);
        mRvNewsList.addHeaderView(view);

    }
    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }




//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.iv_inspect_nav:
//               // mDrawerLayout.openDrawer(GravityCompat.START);
//                ((HomeActivity) getActivity()).showDrawerLayout();
//                break;
//        }
//    }
@Override
protected void updateViews(boolean isRefresh) {
}

    @Override
    public void loadData(List<NewsMultiItem> newsList) {
    }

    @Override
    public void loadMoreData(List<NewsMultiItem> newsList) {

    }

    @Override
    public void loadNoData() {

    }

    @Override
    public void loadAdData(NewsInfo newsBean) {
    }
}
