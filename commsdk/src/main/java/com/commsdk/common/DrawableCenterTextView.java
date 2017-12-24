package com.commsdk.common;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 描述：DrawableLeft,Right图片与文本一起居中显示，从而避免使用复杂的布局
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017年05月01日  12:15
 * 版本：2.0
 */

public class DrawableCenterTextView extends TextView{

    public DrawableCenterTextView(Context context, AttributeSet attrs,
                                  int defStyle) {
        super(context, attrs, defStyle);
    }

    public DrawableCenterTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DrawableCenterTextView(Context context) {
        this(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // getCompoundDrawables() : Returns drawables for the left, top, right, and bottom borders.
        Drawable[] drawables = getCompoundDrawables();
        if (drawables != null) {
            // 得到drawableLeft设置的drawable对象
            Drawable leftDrawable = drawables[0];
            if (leftDrawable != null) {
                // 得到leftDrawable的宽度
                int leftDrawableWidth = leftDrawable.getIntrinsicWidth();
                // 得到drawable与text之间的间距
                int drawablePadding = getCompoundDrawablePadding();
                // 得到文本的宽度
                int textWidth = (int) getPaint().measureText(getText().toString().trim());
                int bodyWidth = leftDrawableWidth + drawablePadding + textWidth;
                canvas.save();
                canvas.translate((getWidth() - bodyWidth) / 2, 0);
            }
        }
        super.onDraw(canvas);
    }
}
