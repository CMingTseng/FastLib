package com.fast.library.tools;

import com.fast.library.interfaces.BackExit;
import com.fast.library.ui.ActivityStack;

/**
 * 说明：默认退出处理
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/5 17:07
 * <p/>
 * 版本：verson 1.0
 */
public class SimpleBackExit implements BackExit {
    @Override
    public void showTips() {
    }

    @Override
    public void exit() {
        ActivityStack.create().AppExit();
    }

    @Override
    public long setWaitTime() {
        return 2000;
    }
}
