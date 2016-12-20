package com.gyf.gyf.Utils;

import android.util.Log;

/**
 * Created by 高烨峰 on 2016/11/13.
 * 可开关的日志工具类,工具类标识方便全部替换成注释
 */
public class LogUtils {
    //日志开关,完全去掉日志请将两行日志代码全局替换成注释
    private static final boolean DEBUG = true;

    /**
     * 非静态方法传this,否则传null或字符串;
     */
    public static void d(String tag,String msg) {
        //debug模式为ture才继续
        if (!DEBUG) {
            return;
        }
        //去掉\r,android studio的日志输出框为linux,不识别\r
        msg = msg.replace("\r","");
        // 使用Log来显示调试信息,因为log在实现上每个message有4076字节的长度限制,汉字占用3~4个字节
        // ,所以以1000字符分节最安全
        //可以适当增长maxLength
        int maxLength = 1000;
        int length = msg.length();
        if(length > maxLength) {
            for(int i=0;i<length;i+=maxLength){
                if(i+maxLength<length)
                    Log.d("日志d:"+tag,msg.substring(i, i+maxLength));
                else
                    Log.d("日志d:"+tag,msg.substring(i, length));
            }
        } else
            Log.d("日志d:"+tag,msg);
    }

    public static void e(Object tag, String msg) {
        //debug模式为ture才继续
        if (!DEBUG) {
            return;
        }
        //去掉\r,android studio的日志输出框为linux,不识别\r
        msg = msg.replace("\r","");
        // 使用Log来显示调试信息,因为log在实现上每个message有4076字节的长度限制,汉字占用3~4个字节
        // ,所以以1000字符分节最安全
        //可以适当增长maxLength
        int maxLength = 1000;
        int length = msg.length();
        if(length > maxLength) {
            for(int i=0;i<length;i+=maxLength){
                if(i+maxLength<length)
                    Log.e("日志e:"+tag,msg.substring(i, i+maxLength));
                else
                    Log.e("日志e:"+tag,msg.substring(i, length));
            }
        } else
            Log.e("日志e:"+tag,msg);
    }
}
