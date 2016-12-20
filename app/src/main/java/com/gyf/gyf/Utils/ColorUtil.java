package com.gyf.gyf.Utils;

import android.graphics.Color;

import java.util.Random;

public class ColorUtil {
	/**
	 * 随机生成漂亮的颜色
	 * @return
	 */
	public static int randomColor(){
		Random random = new Random();
		int red = random.nextInt(150);
		int green = random.nextInt(150);
		int blue = random.nextInt(150);
		return Color.rgb(red, green, blue);//使用rgb混合生成一种新的颜色
	}
}
