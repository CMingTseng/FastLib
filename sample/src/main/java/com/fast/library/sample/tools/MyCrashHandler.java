package com.fast.library.sample.tools;

import com.fast.library.sample.R;
import com.fast.library.sample.config.C;
import com.fast.library.ui.Toast;
import com.fast.library.utils.AndroidInfoUtils;
import com.fast.library.utils.CrashHandler;
import com.fast.library.utils.DateUtils;
import com.fast.library.utils.UIUtils;

import java.io.File;

/**
 * 说明：崩溃日志处理
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 21:03
 * <p/>
 * 版本：verson 1.0
 */
public class MyCrashHandler extends CrashHandler{

    private final static MyCrashHandler crashHandler = new MyCrashHandler();

    public static MyCrashHandler getInstance(){
        return crashHandler;
    }

    @Override
    public void upCrashLog(File file, String error) {

    }

    @Override
    public String setFileName() {
        return AndroidInfoUtils.getAndroidId()+"_crash_" + DateUtils.getNowTime(DateUtils.FORMAT_YYYY_MM_DD_HH_MM_SS_4)+".txt";
    }

    @Override
    public void showCrashTip() {
        super.showCrashTip();
        Toast.get().shortToast(UIUtils.getString(R.string.crash_tip));
    }

    @Override
    public String setCrashFilePath() {
        return C.CRASH;
    }

    @Override
    public boolean isCleanHistory() {
        return true;
    }
}
