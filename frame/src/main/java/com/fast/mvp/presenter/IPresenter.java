package com.fast.mvp.presenter;

import android.content.Context;

import com.fast.mvp.view.IView;

/**
 * 说明：IPresenter
 * <p/>
 * 作者：fanly
 * <p/>
 * 类型：Class
 * <p/>
 * 时间：2016/6/15 16:54
 * <p/>
 * 版本：verson 1.0
 */
public interface IPresenter<VH extends IView> {
    void onCreate(Context context,VH view);
    void onStart();
    void onDestroy();
}
