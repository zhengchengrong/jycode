package com.jy.jyjy.module.news.detail;

import com.jy.jyjy.api.bean.NewsDetailInfo;
import com.jy.jyjy.module.base.IBaseView;

/**
 * Created by long on 2016/8/25.
 * 新闻详情接口
 */
@Deprecated
public interface INewsDetailView extends IBaseView {

    /**
     * 显示数据
     * @param newsDetailBean 新闻详情
     */
    void loadData(NewsDetailInfo newsDetailBean);
}
