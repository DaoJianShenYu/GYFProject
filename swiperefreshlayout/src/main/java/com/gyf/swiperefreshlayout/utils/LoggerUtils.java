package com.gyf.swiperefreshlayout.utils;

/**
 * Created by 高烨峰 on 2016/12/2.
 */
public class LoggerUtils {

    /*Logger.d("hello");
    Logger.e("hello");
    Logger.w("hello");
    Logger.v("hello");
    Logger.wtf("hello");
    Logger.json(JSON_CONTENT); // 支持 json
    Logger.xml(XML_CONTENT); // 支持 xml
    Logger.log(DEBUG, "tag", "message", throwable);

    Logger.d("hello %s", "world"); // 支持 String 格式化参数

    Logger.d(list); // 支持 List
    Logger.d(map); // 支持 Map
    Logger.d(set); // 支持 Set
    Logger.d(new String[]); // 支持 Array

    Logger.t("mytag").d("hello"); // 改变一次 TAG

    Logger.e(exception, "message");*/
    public static void loggerInit() {
        com.orhanobut.logger.Logger
                .init("GYF")                 // 设置Log的TAG值，默认值为 PRETTYLOGGER，也可自定义
//                .methodCount(3)                 // 设置Log中调用堆栈的函数行数，默认值为 2，即显示2层
//                .hideThreadInfo()               // 隐藏Log中的线程信息，默认值为 shown，即显示线程信息
//                .logLevel(LogLevel.NONE)        // 设置Log的是否输出，默认值为 LogLevel.FULL，即Log全输出，LogLevel.NONE即无Log输出
//                .methodOffset(0)                // 设置调用堆栈的函数偏移值，默认值为 0，即从打印该Log的函数开始输出堆栈信息
//                .logAdapter(new AndroidLogAdapter()); //设置Log工具，默认值为 AndroidLogAdapter，即 android.util.log
        ;
    }
}
