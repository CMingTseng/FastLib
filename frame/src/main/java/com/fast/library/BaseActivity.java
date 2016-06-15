package com.fast.library;

import android.content.Intent;

import com.fast.library.http.HttpTaskKey;
import com.fast.library.ui.AbstractActivity;
import com.fast.library.ui.ToastUtil;

/**
 * 说明：Activity基类
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2015/12/26 11:29
 * <p/>
 * 版本：verson 1.0
 */
public abstract class BaseActivity extends AbstractActivity implements HttpTaskKey {

    protected final String HTTP_TASK_KEY = "key_"+hashCode();
    @Override
    public String getHttpTaskKey() {
        return HTTP_TASK_KEY;
    }

    @Override
    public void getIntentData(Intent intent) {
    }

    /***************************************************************************************/

    public void shortToast(int res){
        ToastUtil.get().shortToast(res);
    }
    public void shortToast(String res){
        ToastUtil.get().shortToast(res);
    }
    public void longToast(String res){
        ToastUtil.get().longToast(res);
    }
    public void longToast(int res){
        ToastUtil.get().longToast(res);
    }
    public void cancelToast(){
        ToastUtil.get().cancelToast();
    }

    /***************************************************************************************/

}
