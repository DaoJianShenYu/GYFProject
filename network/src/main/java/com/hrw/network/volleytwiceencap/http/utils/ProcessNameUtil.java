package com.hrw.network.volleytwiceencap.http.utils;

import android.app.ActivityManager;
import android.content.Context;

import java.util.List;

/**
 * Created by 高烨峰 on 2016/12/6.
 */
public class ProcessNameUtil {
    public static String getProcessName(Context cxt, int pid) {
        ActivityManager am = (ActivityManager) cxt.getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> runningApps = am.getRunningAppProcesses();
        if (runningApps != null && !runningApps.isEmpty()) {
            for (ActivityManager.RunningAppProcessInfo procInfo : runningApps) {
                if (procInfo.pid == pid) {
                    return procInfo.processName;
                }
            }
        }

        return null;
    }
}
