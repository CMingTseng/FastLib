package com.fast.library.sample.activity;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.widget.FrameLayout;

import com.fast.library.sample.R;
import com.fast.library.sample.fragment.ContentFragment;
import com.fast.library.ui.ContentView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：
 * <p/>
 * 作者：fanly
 * <p/>
 * 类型：Class
 * <p/>
 * 时间：2016/6/23 13:10
 * <p/>
 * 版本：verson 1.0
 */
@ContentView(R.layout.activity_fragment)
public class FragmentActivity extends CommonActivity {

    @BindView(R.id.content)
    FrameLayout content;

    ContentFragment fragment;

    @Override
    public int createLoaderID() {
        return 0;
    }

    @Override
    public void onInitStart() {
        if (fragment == null){
            fragment = new ContentFragment();
        }
        changeFragment(R.id.content, fragment);
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }


}
