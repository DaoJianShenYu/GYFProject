package com.hrw.network;

import android.app.Application;
import android.content.Context;

import com.hrw.network.volleytwiceencap.http.HttpLoader;

/**
 * Created by 高烨峰 on 2016/12/16.
 */
public class MyApplication extends Application {
    public static HttpLoader HL;
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        HL = HttpLoader.getInstance(this);
        context = this;
    }
}
