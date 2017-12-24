package com.commsdk.autolayout.utils;

import android.util.TypedValue;

/**
 * 描述：
 * 作者：Linxz
 * E-mail:lin_xiao_zhang@163.com
 * 时间:2017/4/22
 * 版本：2.0
 */
public class DimenUtils {
    private static int getComplexUnit(int data)
    {
        return TypedValue.COMPLEX_UNIT_MASK & (data >> TypedValue.COMPLEX_UNIT_SHIFT);
    }

    public static boolean isPxVal(TypedValue val)
    {
        if (val != null && val.type == TypedValue.TYPE_DIMENSION &&
                getComplexUnit(val.data) == TypedValue.COMPLEX_UNIT_PX)
        {
            return true;
        }
        return false;
    }
}
