package com.gyf.gyf.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 高烨峰 on 2016/11/10.
 * 获取格式化时间的工具类
 */
public class GetTimeUtils {
    /**
     * 获取格式化时间的工具类
     * @return "MM-dd HH:mm:ss"
     */
    public static String getTime() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm:ss");
        String time = simpleDateFormat.format(date);
        return time;
    }
}
