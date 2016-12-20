package com.hrw.network.volleytwiceencap.http.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2016/12/8.
 */
public class PackInfoUtils {
    public static String getPackageVersion(Context context) {
        try {
            PackageInfo packinfo = null;
            packinfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String version = packinfo.versionName;
            return version;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "解析版本号失败";
        }
    }
}
