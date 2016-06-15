package com.fast.library.sample.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fast.library.Adapter.recyclerview.BaseRecyclerAdapter;
import com.fast.library.sample.R;
import com.fast.library.sample.contract.MainContract;
import com.fast.library.sample.presenter.MainPresenterImpl;
import com.fast.library.tools.BackExit;
import com.fast.library.tools.BackTools;
import com.fast.library.ui.ContentView;
import com.fast.mvp.loader.PresenterFactory;
import com.fast.mvp.loader.PresenterLoader;

import butterknife.BindView;
import butterknife.ButterKnife;

@ContentView(R.layout.activity_main)
public class MainActivity extends CommonActivity<MainContract.Presenter> implements BaseRecyclerAdapter.OnItemClickListener,MainContract.View {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerView;

    @Override
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        ButterKnife.bind(this);
        //初始化LoaderManager
        getSupportLoaderManager().initLoader(createLoaderID(),null,this);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getPresenter().onCreate(this,this);
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
            default:
                String data = (String) ((BaseRecyclerAdapter)recyclerView.getAdapter()).getData().get(position);
                shortToast(data);
                break;
        }
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showError() {

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
    public void setAdapter(BaseRecyclerAdapter<String> adapter) {
        recyclerView.setAdapter(adapter);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }
}
