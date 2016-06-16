package com.fast.library.sample.presenter;

import com.fast.library.sample.R;
import com.fast.library.sample.contract.MainContract;
import com.fast.library.utils.UIUtils;

import java.util.Arrays;

/**
 * 说明：MainPresenterImpl
 * <p/>
 * 作者：fanly
 * <p/>
 * 类型：Class
 * <p/>
 * 时间：2016/6/15 18:05
 * <p/>
 * 版本：verson 1.0
 */
public class MainPresenterImpl extends MainContract.Presenter {

    @Override
    public void onStart() {
        getMvpView().refresh(Arrays.asList(UIUtils.getStringArray(R.array.main)));
    }

}
