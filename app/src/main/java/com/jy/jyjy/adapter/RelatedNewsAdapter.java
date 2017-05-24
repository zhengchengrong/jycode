package com.jy.jyjy.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.jy.jyjy.R;
import com.jy.jyjy.api.bean.NewsItemInfo;
import com.jy.jyjy.module.news.detail.NewsDetailActivity;
import com.jy.jyjy.utils.DefIconFactory;
import com.jy.jyjy.utils.ImageLoader;
import com.jy.jyjy.utils.StringUtils;
import com.jy.recycler.adapter.BaseQuickAdapter;
import com.jy.recycler.adapter.BaseViewHolder;

import java.util.List;

/**
 * Created by long on 2016/8/25.
 * 相关新闻适配器
 */
public class RelatedNewsAdapter extends BaseQuickAdapter<NewsItemInfo> {

    public RelatedNewsAdapter(Context context) {
        super(context);
    }

    public RelatedNewsAdapter(Context context, List<NewsItemInfo> data) {
        super(context, data);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_news_list;
    }

    @Override
    protected void convert(BaseViewHolder holder, final NewsItemInfo item) {
        ImageView newsIcon = holder.getView(R.id.iv_icon);
        ImageLoader.loadCenterCrop(mContext, item.getImgsrc(), newsIcon, DefIconFactory.provideIcon());
        holder.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_source, StringUtils.clipNewsSource(item.getSource()))
                .setText(R.id.tv_time, item.getPtime());
        holder.getConvertView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NewsDetailActivity.launch(mContext, item.getId());
            }
        });
    }
}
