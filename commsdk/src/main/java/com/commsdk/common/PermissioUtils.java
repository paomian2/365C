package com.commsdk.common;

import android.app.Activity;
import android.content.pm.PackageManager;

/**
 * author: Wme
 * date: 2017/1/11 0011.
 */
public class PermissioUtils {

    public static boolean isHavePermission( Activity activity,String permissionname, String packname) {
        PackageManager pm = activity.getPackageManager();
        boolean permission = (PackageManager.PERMISSION_GRANTED ==
                pm.checkPermission(permissionname, packname));
        if (permission) {
            return true;
        } else {
            return false;
        }

    }
}
