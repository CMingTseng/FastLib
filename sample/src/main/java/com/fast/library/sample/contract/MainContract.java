package com.fast.library.sample.contract;

import com.fast.mvp.BaseContract;

import java.util.List;

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
        void refresh(List<String> data);
    }

    abstract class Presenter extends BasePresenter<View> {

    }

}
