package com.fast.library.sample.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fast.library.Adapter.recyclerview.BaseRecyclerAdapter;
import com.fast.library.sample.R;
import com.fast.library.sample.adapter.MainAdapter;
import com.fast.library.sample.contract.MainContract;
import com.fast.library.sample.presenter.MainPresenterImpl;
import com.fast.library.tools.BackExit;
import com.fast.library.tools.BackTools;
import com.fast.library.tools.RecyclerViewTools;
import com.fast.library.ui.ContentView;
import com.fast.library.utils.StatusBarUtils;
import com.fast.mvp.loader.PresenterFactory;
import com.fast.mvp.loader.PresenterLoader;

import java.util.List;

import butterknife.BindView;

@ContentView(R.layout.activity_main)
public class MainActivity extends CommonActivity<MainContract.Presenter> implements BaseRecyclerAdapter.OnItemClickListener,MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    private MainAdapter mAdapter;

    @Override
    public void onInitStart() {
        StatusBarUtils.setTranslucent(this);
        setSupportActionBar(toolbar);
        getPresenter().attachView(this);

        mAdapter = new MainAdapter(recyclerView,null);
        RecyclerViewTools recyclerViewTools = new RecyclerViewTools(recyclerView);
        recyclerViewTools.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(this);

        getPresenter().onStart();
    }

    @Override
    public int createLoaderID() {
        return hashCode();
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
            case 2:
                showActivity(FragmentActivity.class);
                break;
            default:
                shortToast(mAdapter.getData().get(position));
                break;
        }
    }

    @Override
    public Loader<MainContract.Presenter> onCreateLoader(int id, Bundle args) {
        return new PresenterLoader<>(this, new PresenterFactory<MainContract.Presenter>() {
            @Override
            public MainContract.Presenter create() {
                return new MainPresenterImpl();
            }
        });
    }

    @Override
    public void refresh(List<String> data) {
        mAdapter.refresh(data);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String msg) {
        shortToast(msg);
    }
}
