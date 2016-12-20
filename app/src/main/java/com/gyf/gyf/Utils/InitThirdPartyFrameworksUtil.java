package com.gyf.gyf.Utils;

import android.app.ActivityManager;
import android.content.Context;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.List;

/**
 * Created by 高烨峰 on 2016/12/6.
 */
public class InitThirdPartyFrameworksUtil {
    public static void init(Context context) {
        //只对包名进程进行一次初始化
        String curProcess = getProcessName(context, (android.os.Process.myPid()));
        if (!context.getPackageName().equals(curProcess)) {
            return;
        }
        //初始化Logger
        com.orhanobut.logger.Logger.init("葫芦娃");
        ////初始化ImageLoader
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(context));
    }

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
