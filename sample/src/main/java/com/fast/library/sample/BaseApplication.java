package com.fast.library.sample;

import android.app.Application;

import com.fast.library.FastFrame;
import com.fast.library.http.HttpConfig;
import com.fast.library.sample.config.C;
import com.fast.library.sample.tools.MyCrashHandler;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Headers;

/**
 * 说明：BaseApplication
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 20:49
 * <p/>
 * 版本：verson 1.0
 */
public class BaseApplication extends Application{

    //gradlew install  gradlew bintrayUpload
    private static BaseApplication mApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化FastFrame框架
        FastFrame.init(this);
        //崩溃日志处理
        MyCrashHandler.getInstance().init();
        //网络请求配置
        HttpConfig.Builder builder = new HttpConfig.Builder();
        builder.setTrustAll(true);
        builder.setTimeout(C.TIME_OUT);
        builder.build().init();

        mApplication = this;
    }

    public static BaseApplication getApplication(){
        return mApplication;
    }
}
