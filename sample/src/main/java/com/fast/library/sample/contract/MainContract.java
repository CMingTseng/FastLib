package com.fast.library.sample.contract;

import android.support.v7.widget.RecyclerView;

import com.fast.library.Adapter.recyclerview.BaseRecyclerAdapter;
import com.fast.mvp.BaseContract;
import com.fast.mvp.presenter.IPresenter;

/**
 * 说明：MainContract
 * <p/>
 * 作者：fanly
 * <p/>
 * 类型：Class
 * <p/>
 * 时间：2016/6/15 17:34
 * <p/>
 * 版本：verson 1.0
 */
public interface MainContract extends BaseContract{

    interface View extends BaseView{
        void setAdapter(BaseRecyclerAdapter<String> adapter);
        RecyclerView getRecyclerView();
    }

    interface Presenter extends IPresenter<View>{

    }

}
