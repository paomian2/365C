package com.commsdk.autolayout.attr;

import android.view.View;
import android.view.ViewGroup;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017/4/22
 * 版本：2.0
 */
public class MarginAttr extends AutoAttr{

    public MarginAttr(int pxVal, int baseWidth, int baseHeight)
    {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal()
    {
        return Attrs.MARGIN;
    }

    @Override
    protected boolean defaultBaseWidth()
    {
        return false;
    }

    @Override
    public void apply(View view)
    {
        if (!(view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams))
        {
            return;
        }
        if (useDefault())
        {
            ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            lp.leftMargin = lp.rightMargin = getPercentWidthSize();
            lp.topMargin = lp.bottomMargin = getPercentHeightSize();
            return;
        }
        super.apply(view);
    }

    @Override
    protected void execute(View view, int val)
    {
        ViewGroup.MarginLayoutParams lp = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        lp.leftMargin = lp.rightMargin = lp.topMargin = lp.bottomMargin = val;
    }
}
