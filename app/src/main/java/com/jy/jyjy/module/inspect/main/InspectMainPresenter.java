package com.jy.jyjy.module.inspect.main;

import com.jy.jyjy.adapter.item.NewsMultiItem;
import com.jy.jyjy.api.NewsUtils;
import com.jy.jyjy.api.RetrofitService;
import com.jy.jyjy.api.bean.NewsInfo;
import com.jy.jyjy.module.base.IBasePresenter;
import com.jy.jyjy.module.news.newslist.INewsListView;
import com.jy.jyjy.utils.ToastUtils;
import com.jy.jyjy.widget.EmptyLayout;
import com.orhanobut.logger.Logger;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Func1;

/**
 * Created by zcr on 2017/5/26.
 */

public class InspectMainPresenter  implements IBasePresenter {
    private IInspectMainView mView;
    private String mNewsId;

    private int mPage = 0;

    public InspectMainPresenter(IInspectMainView view, String newsId) {
        this.mView = view;
        this.mNewsId = newsId;
    }

    @Override
    public void getData(final boolean isRefresh) {
        RetrofitService.getNewsList(mNewsId, mPage)
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        if (!isRefresh) {
                            mView.showLoading();
                        }
                    }
                })
                .filter(new Func1<NewsInfo, Boolean>() {
                    @Override
                    public Boolean call(NewsInfo newsBean) {
                        if (NewsUtils.isAbNews(newsBean)) {
                            mView.loadAdData(newsBean);
                        }
                        return !NewsUtils.isAbNews(newsBean);
                    }
                }).compose(mTransformer)
                .subscribe(new Subscriber<List<NewsMultiItem>>() {
                    @Override
                    public void onCompleted() {
                        Logger.w("onCompleted " + isRefresh);
                        if (isRefresh) {
                            mView.finishRefresh();
                        } else {
                            mView.hideLoading();
                        }
                    }
                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString() + " " + isRefresh);
                        if (isRefresh) {
                            mView.finishRefresh();
                            // 可以提示对应的信息，但不更新界面
                            ToastUtils.showToast("刷新失败提示什么根据实际情况");
                        } else {
                            mView.showNetError(new EmptyLayout.OnRetryListener() {
                                @Override
                                public void onRetry() {
                                    getData(false);
                                }
                            });
                        }
                    }
                    @Override
                    public void onNext(List<NewsMultiItem> newsMultiItems) {
                        mView.loadData(newsMultiItems);
                        mPage++;
                    }
                });
    }

    @Override
    public void getMoreData() {
        RetrofitService.getNewsList(mNewsId, mPage)
                .compose(mTransformer)
                .subscribe(new Subscriber<List<NewsMultiItem>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        Logger.e(e.toString());
                        mView.loadNoData();
                    }

                    @Override
                    public void onNext(List<NewsMultiItem> newsList) {
                        mView.loadMoreData(newsList);
                        mPage++;
                    }
                });
    }

    /**
     * 统一变换
     */
    private Observable.Transformer<NewsInfo, List<NewsMultiItem>> mTransformer = new Observable.Transformer<NewsInfo, List<NewsMultiItem>>() {
        @Override
        public Observable<List<NewsMultiItem>> call(Observable<NewsInfo> newsInfoObservable) {
            return newsInfoObservable
                    .map(new Func1<NewsInfo, NewsMultiItem>() {
                        @Override
                        public NewsMultiItem call(NewsInfo newsBean) {
                            if (NewsUtils.isNewsPhotoSet(newsBean.getSkipType())) {
                                return new NewsMultiItem(NewsMultiItem.ITEM_TYPE_PHOTO_SET, newsBean);
                            }
                            return new NewsMultiItem(NewsMultiItem.ITEM_TYPE_NORMAL, newsBean);
                        }
                    })
                    .toList()
                    .compose(mView.<List<NewsMultiItem>>bindToLife());
        }
    };
}
