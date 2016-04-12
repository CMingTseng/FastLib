package com.fast.library.sample.banner;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import com.fast.library.banner.holder.Holder;
import com.fast.library.glide.GlideLoader;

/**
 * 说明：BannerImageHolder
 * <p/>
 * 作者：fanly
 * <p/>
 * 时间：2016/4/12 21:44
 * <p/>
 * 版本：verson 1.0
 */
public class BannerImageHolder implements Holder<String>{

    private ImageView imageView;

    @Override
    public View createView(Context context) {
        imageView = new ImageView(context);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return imageView;
    }

    @Override
    public void convert(Context context, int position, String item) {
        GlideLoader.into(item, imageView);
    }
}
