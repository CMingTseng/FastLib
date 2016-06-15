package com.fast.library.sample.activity;

import android.os.Bundle;
import android.view.View;

import com.fast.library.BaseActivity;
import com.fast.mvp.presenter.IPresenter;

/**
 * 说明：CommonActivity
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 20:50
 * <p/>
 * 版本：verson 1.0
 */
public abstract class CommonActivity<Presenter extends IPresenter> extends BaseActivity<Presenter>{
    @Override
    public void onInit(Bundle bundle) {
        addListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    public void addListener(){}

    @Override
    public void clickView(View v, int id) {

    }
}
