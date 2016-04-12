package com.fast.library.sample.activity;

import android.os.Bundle;
import android.view.View;

import com.fast.library.banner.BannerView;
import com.fast.library.banner.holder.BannerHolderCreator;
import com.fast.library.banner.listener.OnItemClickListener;
import com.fast.library.sample.R;
import com.fast.library.sample.banner.BannerImageHolder;
import com.fast.library.ui.ContentView;
import com.fast.library.ui.Toast;
import com.fast.library.utils.UIUtils;

import java.util.Arrays;
import java.util.List;

import butterknife.Bind;
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

    @Bind(R.id.bannerView)
    BannerView bannerView;

    private long time = 2000;

    private List<String> data;

    @Override
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        ButterKnife.bind(this);

        data = Arrays.asList(UIUtils.getStringArray(R.array.banner_three));
        bannerView.setPages(new BannerHolderCreator() {
            @Override
            public Object createHolder() {
                return new BannerImageHolder();
            }
        }, data);
        bannerView.setPoint(R.mipmap.home_banner_selected, R.mipmap.home_banner_normal);
        bannerView.setOnItemClickListener(this);
    }

    @OnClick({R.id.btn_start, R.id.btn_stop, R.id.btn_add})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                bannerView.start(time);
                break;
            case R.id.btn_stop:
                bannerView.stop();
                break;
            case R.id.btn_add:
                if (data.size() <= 1){
                    data.clear();
                    data.addAll(Arrays.asList(UIUtils.getStringArray(R.array.banner_three)));
                }else {
                    data.clear();
                    data.addAll(Arrays.asList(UIUtils.getStringArray(R.array.banner_one)));
                }
                bannerView.refresh();
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        bannerView.start(time);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bannerView.stop();
    }

    @Override
    public void onItemClick(int position) {
        Toast.get().shortToast(data.get(position));
    }
}
