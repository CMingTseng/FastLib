package com.fast.library.sample.presenter;

import android.content.Context;

import com.fast.library.sample.R;
import com.fast.library.sample.activity.MainActivity;
import com.fast.library.sample.adapter.MainAdapter;
import com.fast.library.sample.contract.MainContract;
import com.fast.library.tools.RecyclerViewTools;
import com.fast.library.utils.UIUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class MainPresenterImpl implements MainContract.Presenter{

    private List<String> datas = new ArrayList<>();
    private RecyclerViewTools recyclerViewTools;
    private MainAdapter mAdapter;

    @Override
    public void onCreate(Context context, MainContract.View view) {
        datas = Arrays.asList(UIUtils.getStringArray(R.array.main));
        recyclerViewTools = new RecyclerViewTools(view.getRecyclerView());
        mAdapter = new MainAdapter(view.getRecyclerView(),datas);
        recyclerViewTools.setHasFixedSize(true);
        mAdapter.setOnItemClickListener((MainActivity)context);
        view.setAdapter(mAdapter);
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onDestroy() {

    }
}
