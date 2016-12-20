package com.hrw.network.volleytwiceencap.http.utils;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by Administrator on 2016/11/18.
 */
public class ColorUtils {
    /**
     * 随机生成漂亮的颜色
     * @return
     */
    public static int randomColor(){
        Random random = new Random();
        int red = random.nextInt(150);//0-190
        int green = random.nextInt(150);//0-190
        int blue = random.nextInt(150);//0-190
        return Color.rgb(red, green, blue);//使用rgb混合生成一种新的颜色
    }
}
