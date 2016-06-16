package com.fast.library.sample.contract;

import com.fast.mvp.view.MvpView;

/**
 * 说明：BaseView
 * <p/>
 * 作者：fanly
 * <p/>
 * 类型：Class
 * <p/>
 * 时间：2016/6/15 17:36
 * <p/>
 * 版本：verson 1.0
 */
public interface BaseView extends MvpView {
    //显示加载进度
    void showLoading();
    //隐藏加载进度
    void hideLoading();
    //显示加载错误
    void showError(String msg);
}
