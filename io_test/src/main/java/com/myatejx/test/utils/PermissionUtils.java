package com.myatejx.test.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2018/4/12.
 */

public class PermissionUtils {

    /**
     * 检查权限，如果都通过了，就返回true，否则申请权限，并返回false。
     *
     * @param activity
     * @param requestCode
     * @param permissionRequests
     * @return
     */
    public static boolean checkPermission(Activity activity, int requestCode, String... permissionRequests) {
        List<String> list = new ArrayList<>();
        for (String p : permissionRequests) {
            if (ContextCompat.checkSelfPermission(activity, p) != PackageManager.PERMISSION_GRANTED) {
                list.add(p);
            }
        }
        if (list.size() == 0) {
            return true;
        } else {
            String[] array = new String[list.size()];
            list.toArray(array);
            ActivityCompat.requestPermissions(activity, array, requestCode);
            return false;
        }
    }


}
