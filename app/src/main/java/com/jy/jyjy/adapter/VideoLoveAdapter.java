package com.jy.jyjy.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.jy.jyjy.R;
import com.jy.jyjy.local.table.VideoInfo;
import com.jy.jyjy.utils.DefIconFactory;
import com.jy.jyjy.utils.ImageLoader;
import com.jy.recycler.adapter.BaseQuickAdapter;
import com.jy.recycler.adapter.BaseViewHolder;

/**
 * Created by long on 2016/12/13.
 * Video收藏适配器
 */
public class VideoLoveAdapter extends BaseQuickAdapter<VideoInfo> {

    public VideoLoveAdapter(Context context) {
        super(context);
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.adapter_video_love;
    }

    @Override
    protected void convert(BaseViewHolder holder, final VideoInfo item) {
        ImageView ivThumb = holder.getView(R.id.iv_thumb);
        ImageLoader.loadFitCenter(mContext, item.getCover(), ivThumb, DefIconFactory.provideIcon());
        holder.setText(R.id.tv_title, item.getTitle())
                .setText(R.id.tv_desc, item.getSectiontitle());
    }
}
