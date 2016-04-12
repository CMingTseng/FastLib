package com.fast.library.sample.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fast.library.Adapter.recyclerview.BaseRecyclerAdapter;
import com.fast.library.sample.R;
import com.fast.library.sample.adapter.MainAdapter;
import com.fast.library.tools.BackExit;
import com.fast.library.tools.BackTools;
import com.fast.library.tools.RecyclerViewTools;
import com.fast.library.ui.ContentView;
import com.fast.library.utils.UIUtils;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

@ContentView(R.layout.activity_main)
public class MainActivity extends CommonActivity implements BaseRecyclerAdapter.OnItemClickListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private MainAdapter mAdapter;
    private RecyclerViewTools recyclerViewTools;
    private List<String> datas;

    @Override
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        initMainData();
    }

    private void initMainData() {
        datas = Arrays.asList(UIUtils.getStringArray(R.array.main));
        recyclerViewTools = new RecyclerViewTools(recyclerView);
        mAdapter = new MainAdapter(recyclerView,datas);
        recyclerViewTools.setHasFixedSize(true);
        mAdapter.setOnItemClickListener(this);
        recyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.fab)
    public void onClick(View view) {
        Snackbar.make(view, "你好", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    @Override
    public void onBackPressed() {
        BackTools.onBackPressed(new BackExit(){
            @Override
            public void showTips() {
                Snackbar.make(toolbar, R.string.exit_tip, Snackbar.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(View view, int position) {
        switch (position){
            case 0:
                showActivity(BannerActivity.class);
                break;
            case 1:
                showActivity(HttpActivity.class);
                break;
            default:
                shortToast(datas.get(position));
                break;
        }
    }
}
