package com.a365vintagewine.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.commsdk.base.Config;
import com.commsdk.common.LogUtil;
import com.commsdk.common.StringUtils;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年10月12日  11:17
 * 版本：3.0
 */

public class TvLoadDrawableUtils {

    private Context mContext;
    private String url;
    private TextView textView;

    public static TvLoadDrawableUtils getInstance(TextView textView,String url){
       return  new TvLoadDrawableUtils(textView,url);
    }

    private TvLoadDrawableUtils(TextView textView,String url){
        this.textView=textView;
        this.mContext=textView.getContext();
        this.url=url;
    }

    public void setDrawableToTop(){
        try {
            if(!StringUtils.isEmpty(url) && !url.contains("http")){
                url= Config.BASE_URL+url;
            }
            Glide.with(mContext).load(url).asBitmap().into(new Target<Bitmap>() {
                @Override
                public void onLoadStarted(Drawable placeholder) {

                }

                @Override
                public void onLoadFailed(Exception e, Drawable errorDrawable) {

                }

                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                    Drawable topDrawable =new BitmapDrawable(resource);
                    topDrawable.setBounds(0, 0, topDrawable.getMinimumWidth(), topDrawable.getMinimumHeight());
                    //textView.setCompoundDrawablePadding(20);
                    textView.setCompoundDrawables(null, topDrawable, null, null);
                }

                @Override
                public void onLoadCleared(Drawable placeholder) {

                }

                @Override
                public void getSize(SizeReadyCallback cb) {

                }

                @Override
                public void setRequest(Request request) {

                }

                @Override
                public Request getRequest() {
                    return null;
                }

                @Override
                public void onStart() {

                }

                @Override
                public void onStop() {

                }

                @Override
                public void onDestroy() {

                }
            });
        }catch (Exception e){
            e.printStackTrace();
            LogUtil.d("","首页加载四个活动图标出错啦！！！");
        }
    }
}
