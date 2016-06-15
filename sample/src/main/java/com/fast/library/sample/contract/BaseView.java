package com.fast.library.sample.contract;

import com.fast.mvp.view.IView;

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
public interface BaseView extends IView{
    //显示加载进度
    void showProgress();
    //隐藏加载进度
    void hideProgress();
    //显示加载错误
    void showError();
}
