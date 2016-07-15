package com.fast.library.view;

import android.os.Bundle;
import android.view.View;
import com.fast.library.BaseFragment;
import com.fast.library.utils.LogUtils;

/**
 * 说明：懒加载Fragment
 * <p/>
 * 作者：fanly
 * <p/>
 * 类型：Class
 * <p/>
 * 时间：2016/6/16 13:31
 * <p/>
 * 版本：verson 1.0
 */
public abstract class BaseLazyFragment extends BaseFragment{

    public final static String TAG = "BaseLazyFragment";

    private boolean isFirstResume = true;
    private boolean isFirstVisible = true;
    private boolean isFirstInvisible = true;
    private boolean isPrepared = false;

    private int count = 1;

    @Override
    protected void onInit(Bundle savedInstanceState, View view) {
        onInitCreate(savedInstanceState,view);
        initPrepare();
    }

    private synchronized void initPrepare(){
        LogUtils.e(TAG,"initPrepare=="+count);
        count++;
        if (isPrepared){
            onFirstUserVisible();
        }else {
            isPrepared = true;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (isFirstResume){
            isFirstResume = false;
            return;
        }
        if (getUserVisibleHint()){
            onUserVisible();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getUserVisibleHint()){
            onUserInvisible();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        LogUtils.e(TAG,"setUserVisibleHint=="+count);
        count++;
        if (isVisibleToUser){
            if (isFirstVisible){
                isFirstVisible = false;
                initPrepare();
            }else {
                onUserVisible();
            }
        }else {
            if (isFirstInvisible){
                isFirstInvisible = false;
                onFirstUserVisible();
            }else {
                onUserInvisible();
            }
        }
    }

    /**
     * 创建View时调用
     * @param savedInstanceState
     * @param view
     */
    protected abstract void onInitCreate(Bundle savedInstanceState, View view);

    /**
     * 说明：第一次界面可见调用
     */
    protected abstract void onFirstUserVisible();

    /**
     * 说明：界面可见调用
     */
    protected abstract void onUserVisible();

    /**
     * 说明：界面不可见调用
     */
    protected abstract void onUserInvisible();

}
