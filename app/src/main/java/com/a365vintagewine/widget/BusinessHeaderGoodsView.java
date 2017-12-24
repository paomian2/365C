package com.a365vintagewine.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.a365vintagewine.R;

/**
 * 描述：商家商品列表
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年09月08日  13:00
 * 版本：3.0
 */

public class BusinessHeaderGoodsView extends LinearLayout{

    private Context mContext;
    public BusinessHeaderGoodsView(Context context) {
        super(context);
        this.mContext=context;
    }

    public BusinessHeaderGoodsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
        this.mContext=context;
    }

    public BusinessHeaderGoodsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext=context;
    }

    private void initView(){
        LayoutInflater inflater=LayoutInflater.from(mContext);
        this.removeAllViews();
        View view=inflater.inflate(R.layout.item_business_goods,null);
    }


}
