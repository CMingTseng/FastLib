package com.fast.library.sample.config;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.integration.okhttp3.OkHttpUrlLoader;
import com.bumptech.glide.load.model.GlideUrl;
import com.fast.library.glide.GlideConfig;
import com.fast.library.http.HttpConfig;

import java.io.InputStream;

/**
 * 说明：MyGlideConfig
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 22:14
 * <p/>
 * 版本：verson 1.0
 */
public class MyGlideConfig extends GlideConfig{

    @Override
    public boolean isRGB8888() {
        return true;
    }

    @Override
    public int setDiskCacheType() {
        return GlideConfig.TYPE_EXTERNAL_STORAGE;
    }

    @Override
    public String setDiskCacheName() {
        return C.IMAGE;
    }

    @Override
    public void registerComponents(Context context, Glide glide) {
        glide.register(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(HttpConfig.get().getOkHttpClient()));
    }
}
