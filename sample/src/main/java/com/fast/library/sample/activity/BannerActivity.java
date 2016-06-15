package com.fast.library.sample.activity;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;

import com.fast.library.banner.BannerView;
import com.fast.library.banner.holder.BannerHolderCreator;
import com.fast.library.banner.listener.OnItemClickListener;
import com.fast.library.sample.R;
import com.fast.library.sample.banner.BannerImageHolder;
import com.fast.library.ui.ContentView;
import com.fast.library.ui.ToastUtil;
import com.fast.library.utils.UIUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 说明：BannerActivity
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 21:40
 * <p/>
 * 版本：verson 1.0
 */
@ContentView(R.layout.activity_banner)
public class BannerActivity extends CommonActivity implements OnItemClickListener {

    @BindView(R.id.bannerView)
    BannerView bannerView;

    private BannerHolderCreator<BannerImageHolder> holder;
    private List<String> data = new ArrayList<>();
    private String []urls;

    @Override
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        ButterKnife.bind(this);
        urls = UIUtils.getStringArray(R.array.banner_three);
        Collections.addAll(data, urls);
        holder = new BannerHolderCreator<BannerImageHolder>() {
            @Override
            public BannerImageHolder createHolder() {
                return new BannerImageHolder();
            }
        };
        bannerView.setPages(holder, data);
        bannerView.setPoint(R.mipmap.home_banner_selected, R.mipmap.home_banner_normal);
        bannerView.setOnItemClickListener(this);
    }

    @Override
    public int createLoaderID() {
        return 0;
    }

    @OnClick({R.id.btn_1, R.id.btn_2, R.id.btn_3})
    public void onBClick(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                data.clear();
                urls = UIUtils.getStringArray(R.array.banner_one);
                Collections.addAll(data, urls);
                break;
            case R.id.btn_2:
                data.clear();
                urls = UIUtils.getStringArray(R.array.banner_two);
                Collections.addAll(data, urls);
                break;
            case R.id.btn_3:
                data.clear();
                urls = UIUtils.getStringArray(R.array.banner_three);
                Collections.addAll(data, urls);
                break;
        }
        if (data.size() > 1){
            bannerView.setPointVisible(true);
            bannerView.setCanLoop(true);
        }else {
            bannerView.setPointVisible(false);
            bannerView.setCanLoop(false);
        }
        bannerView.refresh(holder,data);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bannerView.start(2000);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onItemClick(int position) {
        ToastUtil.get().shortToast(data.get(position));
    }

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }
}
