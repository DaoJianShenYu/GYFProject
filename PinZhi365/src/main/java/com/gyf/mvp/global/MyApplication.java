package com.gyf.mvp.global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.util.Log;

import com.gyf.mvp.utils.ChannelUtil;


/**
 * Created by 高烨峰 on 2016/11/27.
 */
public class MyApplication extends Application {
    public static Context context;
    public static Handler mainHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        mainHandler = new Handler();
        //获取渠道标记
        String channel = ChannelUtil.getChannel(this);
        //设置给友盟
        //AnalyticsConfig.setChannel(channel);
        Log.d("x1",channel);
    }
}
