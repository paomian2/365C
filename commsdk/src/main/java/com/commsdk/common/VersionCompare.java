package com.commsdk.common;

import android.content.Context;
import android.content.pm.PackageManager;

/**版本升级
 * author: Wme
 * date: 2017/2/23 0023.
 */
public class VersionCompare {


    /**获取系统版本号**/
    public static int getCode(Context context)
    {
        int versionCode = 0;
        try {
            versionCode = context.getPackageManager().getPackageInfo("com.lianjiu.b",0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }
    /**获取系统版本号**/
    public static String getName(Context context)
    {
        String versionName = "";
        try {
            versionName = context.getPackageManager().getPackageInfo("com.lianjiu.b",0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

}
