package com.jy.jyjy.adapter.item;

import com.jy.jyjy.api.bean.NewsItemInfo;
import com.jy.recycler.entity.SectionEntity;

/**
 * Created by long on 2016/8/26.
 * 专题列表项
 */
public class SpecialItem extends SectionEntity<NewsItemInfo> {

    public SpecialItem(boolean isHeader, String header) {
        super(isHeader, header);
    }

    public SpecialItem(NewsItemInfo newsItemBean) {
        super(newsItemBean);
    }
}
