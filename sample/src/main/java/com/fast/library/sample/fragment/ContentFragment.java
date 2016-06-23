package com.fast.library.sample.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fast.library.sample.R;
import com.fast.library.ui.ContentView;
import com.fast.library.view.BaseLazyFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 说明：ContentFragment
 * <p/>
 * 作者：fanly
 * <p/>
 * 类型：Class
 * <p/>
 * 时间：2016/6/23 13:12
 * <p/>
 * 版本：verson 1.0
 */
@ContentView(R.layout.fragment_content)
public class ContentFragment extends BaseLazyFragment {
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onInitCreate(Bundle savedInstanceState, View view) {
        ButterKnife.bind(this, view);
    }

    @Override
    protected void onFirstUserVisible() {
        tv.setText("onFirstUserVisible");
    }

    @Override
    protected void onUserVisible() {
        tv.setText("onFirstUserVisible");
    }

    @Override
    protected void onUserInvisible() {
        tv.setText("onUserInvisible");
    }

}
