package com.fast.library.sample.config;

import com.fast.library.utils.SDCardUtils;

import java.io.File;

/**
 * 说明：常用常量
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 21:03
 * <p/>
 * 版本：verson 1.0
 */
public final class C {

    public final static String APP = "simple";
    //崩溃日志保存路径
    public final static String CRASH = SDCardUtils.getExternalStorage() + File.separator + APP + File.separator + "crash" + File.separator;
    //图片路径
    public final static String IMAGE = APP + File.separator + "image";
    //崩溃日志保存路径
    public final static int TIME_OUT = 5000;

}
