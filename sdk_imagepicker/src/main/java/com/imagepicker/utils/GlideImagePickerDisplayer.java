package com.imagepicker.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Glide实现的图片加载
 */
public class GlideImagePickerDisplayer implements IImagePickerDisplayer
{
    @Override
    public void display(Context context, String url, ImageView imageView, int maxWidth, int maxHeight)
    {
        Glide.with(context)
                .load(url)
                .override(maxWidth, maxHeight)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }

    @Override
    public void display(Context context, String url, ImageView imageView, int placeHolder, int errorHolder, int maxWidth, int maxHeight)
    {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .dontAnimate()
                .placeholder(placeHolder)
                .override(maxWidth, maxHeight)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }
}
