package com.jy.jyjy.module.inspect.main;

import com.jy.jyjy.local.table.NewsTypeInfo;

import java.util.List;

/**
 * Created by zcr on 2017/5/24.
 */

public interface IInspectMainView {
    /**
     * 显示主页数据
     * @param mainData     选中栏目
     */
    void loadData(List<NewsTypeInfo> mainData);
}
