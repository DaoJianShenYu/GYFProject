package com.gyf.gyf.Global;

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


/**
 * Created by 高烨峰 on 2016/11/13.
 */
public class BaseApplacation extends Application {
    /**
     * 全局上下文
     */
    public static Context context;

    /**
     * 全局handler
     */
    public static Handler applicationHandler;
    /**
     * app的入口函数
     */
    @Override
    public void onCreate() {
        super.onCreate();
        //1.初始化Context,Android三大Context:Application,Activity,Service
        context = this;
        //2.初始化mainHandler
        applicationHandler = new Handler();
//		new Thread(){
//			public void run() {
//				//在子线程创建handler
//				mainHandler = new Handler();
//				Looper.prepare();//创建轮询器
//				Looper.loop();//开启轮询器
//				mainHandler.sendEmptyMessage(0);
//			};
//		}.start();
        //初始化ImageLoader
        ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(this));
    }
}
