package com.fast.library.sample.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.fast.library.HttpUtils;
import com.fast.library.http.callback.DownloadCallBack;
import com.fast.library.http.callback.ModelCallBack;
import com.fast.library.sample.R;
import com.fast.library.sample.tools.Api;
import com.fast.library.ui.ContentView;
import com.fast.library.utils.SDCardUtils;
import com.fast.library.utils.ToolUtils;

import java.io.File;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 说明：HttpActivity
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/13 0:07
 * <p/>
 * 版本：verson 1.0
 */
@ContentView(R.layout.activity_http)
public class HttpActivity extends CommonActivity {

    @Bind(R.id.tv_info)
    TextView tvInfo;

    String url = "http://60.8.151.207/m.wdjcdn.com/apk.wdjcdn.com/3/d5/88512dbfbc3a46c1e760201c73e4ad53.apk";

    @Override
    public void onInit(Bundle bundle) {
        super.onInit(bundle);
        ButterKnife.bind(this);

        tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.cancel(url);
                tvInfo.setText("已经取消");
            }
        });
    }

    @OnClick({R.id.btn_baidu, R.id.btn_download})
    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_baidu:
                break;
            case R.id.btn_download:
                tvInfo.setText("");
                HttpUtils.download(url,SDCardUtils.getExternalStorage().getAbsolutePath(), "abc.apk", new DownloadCallBack() {

                    @Override
                    public void onSuccess(File target) {
                        tvInfo.setText("下载成功");
                        ToolUtils.installApk(HttpActivity.this,target);
                    }

                    @Override
                    public void onFailure() {
                        tvInfo.setText("下载失败");
                    }

                    @Override
                    public void onProgress(float progress, long networkSpeed) {
                        tvInfo.setText("当前进度："+progress+"  /当前网速："+networkSpeed);
                    }
                });
                break;
        }
    }
}
