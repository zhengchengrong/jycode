package com.jy.jyjy.module.inspect.main;

import com.jy.jyjy.adapter.item.NewsMultiItem;
import com.jy.jyjy.api.bean.NewsInfo;
import com.jy.jyjy.local.table.NewsTypeInfo;
import com.jy.jyjy.module.base.ILoadDataView;

import java.util.List;

/**
 * Created by zcr on 2017/5/24.
 */

public interface IInspectMainView   extends ILoadDataView<List<NewsMultiItem>> {
    /**
     * 加载广告数据
     * @param newsBean 新闻
     */
    void loadAdData(NewsInfo newsBean);
}
