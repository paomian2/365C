package com.commsdk.autolayout.attr;

import android.view.View;

import java.lang.reflect.Method;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017/4/22
 * 版本：2.0
 */
public class MaxWidthAttr extends AutoAttr
{
    public MaxWidthAttr(int pxVal, int baseWidth, int baseHeight)
    {
        super(pxVal, baseWidth, baseHeight);
    }

    @Override
    protected int attrVal()
    {
        return Attrs.MAX_WIDTH;
    }

    @Override
    protected boolean defaultBaseWidth()
    {
        return true;
    }

    @Override
    protected void execute(View view, int val)
    {
        try
        {
            Method setMaxWidthMethod = view.getClass().getMethod("setMaxWidth", int.class);
            setMaxWidthMethod.invoke(view, val);
        } catch (Exception ignore)
        {
        }
    }

    public static MaxWidthAttr generate(int val, int baseFlag)
    {
        MaxWidthAttr attr = null;
        switch (baseFlag)
        {
            case AutoAttr.BASE_WIDTH:
                attr = new MaxWidthAttr(val, Attrs.MAX_WIDTH, 0);
                break;
            case AutoAttr.BASE_HEIGHT:
                attr = new MaxWidthAttr(val, 0, Attrs.MAX_WIDTH);
                break;
            case AutoAttr.BASE_DEFAULT:
                attr = new MaxWidthAttr(val, 0, 0);
                break;
        }
        return attr;
    }

    public static int getMaxWidth(View view)
    {
        try
        {
            Method setMaxWidthMethod = view.getClass().getMethod("getMaxWidth");
            return (int) setMaxWidthMethod.invoke(view);
        } catch (Exception ignore)
        {
        }
        return 0;
    }
}
