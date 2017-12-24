package com.commsdk.autolayout.attr;

import android.view.View;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017/4/22
 * 版本：2.0
 */
public class PaddingAttr extends AutoAttr
{
    public PaddingAttr(int pxVal, int baseWidth, int baseHeight)
    {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal()
    {
        return Attrs.PADDING;
    }

    @Override
    public void apply(View view)
    {
        int l, t, r, b;
        if (useDefault())
        {
            l = r = getPercentWidthSize();
            t = b = getPercentHeightSize();
            view.setPadding(l, t, r, b);
            return;
        }
        super.apply(view);
    }

    @Override
    protected boolean defaultBaseWidth()
    {
        return false;
    }

    @Override
    protected void execute(View view, int val)
    {
        view.setPadding(val, val, val, val);
    }



}
