package com.hrw.memoryleak.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by 高烨峰 on 2016/12/18.
 */
public class MyApplication extends Application {
    public static Handler handler = new Handler();
    public static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
        context = MyApplication.this;
    }
}
