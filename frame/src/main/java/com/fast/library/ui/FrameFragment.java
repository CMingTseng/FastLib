package com.fast.library.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

public abstract class FrameFragment extends Fragment implements OnClickListener {

    public static final int WHICH_MSG = 0x100;
    protected View fragmentRootView;
    protected int resId = 0;

    /**
     * 一个私有回调类，线程中初始化数据完成后的回调
     */
    private interface ThreadDataCallBack {
        void onSuccess();
    }

    private static ThreadDataCallBack callback;

    // 当线程中初始化的数据初始化完成后，调用回调方法
    private static Handler threadHandle = new Handler() {
        @Override
        public void handleMessage(android.os.Message msg) {
            if (msg.what == WHICH_MSG) {
                callback.onSuccess();
            }
        }

    };

    @Override
    public final void onClick(View v) {
        clickView(v,v.getId());
    }

    /**
     * 说明：点击事件
     *
     * @param v
     */
    protected abstract void clickView(View v,int id);

    /**
     * 说明：初始化数据
     */
    protected abstract void onInit(Bundle savedInstanceState,View view);

    /**
     * 说明：设置布局文件
     * @param resId
     */
    protected final void setRootViewResID(int resId){
        this.resId = resId;
    }

    protected int getRootViewResID(){
        return resId;
    }

    /**
     * 说明：在新的线程中初始化数据
     */
    protected void initDataFromThread() {
        callback = new ThreadDataCallBack() {

            @Override
            public void onSuccess() {
                threadDataInited();
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AnnotateViewUtils.init(this);
        fragmentRootView = inflaterView(inflater, container, savedInstanceState);
        return fragmentRootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onInit(savedInstanceState,fragmentRootView);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new Thread(new Runnable() {

            @Override
            public void run() {
                initDataFromThread();
                threadHandle.sendEmptyMessage(WHICH_MSG);
            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T bind(int id) {
        return (T) fragmentRootView.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T bind(int id, boolean click) {
        T view = (T) fragmentRootView.findViewById(id);
        if (click) {
            view.setOnClickListener(this);
        }
        return view;
    }

    /**
     * 说明：如果调用了initDataFromThread()，则当数据初始化完成后将回调该方法。
     */
    protected void threadDataInited() {
    }

    protected abstract View inflaterView(LayoutInflater inflater,
                                         ViewGroup container, Bundle bundle);

}

