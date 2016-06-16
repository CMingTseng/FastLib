package com.fast.library.sample.activity;

import android.os.Bundle;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.TextView;

import com.fast.library.HttpUtils;
import com.fast.library.http.callback.DownloadCallBack;
import com.fast.library.sample.R;
import com.fast.library.sample.http.ServerAPI;
import com.fast.library.ui.ContentView;
import com.fast.library.utils.SDCardUtils;
import com.fast.library.utils.ToolUtils;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import rx.functions.Action1;

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

    @BindView(R.id.tv_info)
    TextView tvInfo;

    String url = "http://60.8.151.207/m.wdjcdn.com/apk.wdjcdn.com/3/d5/88512dbfbc3a46c1e760201c73e4ad53.apk";

    @Override
    public void onInitStart() {
        tvInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HttpUtils.cancel(url);
                tvInfo.setText("已经取消");
            }
        });
    }

    @Override
    public int createLoaderID() {
        return 0;
    }

    @OnClick({R.id.btn_baidu, R.id.btn_download})
    public void onBtnClick(View view) {
        switch (view.getId()) {
            case R.id.btn_baidu:
                ServerAPI.getServerTime()
                        .subscribe(new Action1<String>() {
                            @Override
                            public void call(String s) {
                                tvInfo.setText(s);
                            }
                        });
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

    @Override
    public Loader onCreateLoader(int id, Bundle args) {
        return null;
    }

    @Override
    public void onLoadFinished(Loader loader, Object data) {

    }
}
