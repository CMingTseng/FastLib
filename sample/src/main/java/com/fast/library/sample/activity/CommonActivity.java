package com.fast.library.sample.activity;

import android.os.Bundle;
import android.view.View;

import com.fast.library.BaseActivity;
import com.fast.mvp.presenter.MvpPresenter;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 说明：CommonActivity
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 20:50
 * <p/>
 * 版本：verson 1.0
 */
public abstract class CommonActivity<Presenter extends MvpPresenter> extends BaseActivity<Presenter>{

    private Unbinder mUnbinder;

    @Override
    public void onInitCreate(Bundle bundle) {
        mUnbinder = ButterKnife.bind(this);
        //初始化LoaderManager
        getSupportLoaderManager().initLoader(createLoaderID(),null,this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mUnbinder != null){
            mUnbinder.unbind();
        }
    }
}
