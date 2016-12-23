package com.hrw.memoryleak.utils;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

public class ToastUtils {

	
	private static Toast toast;

	private static Handler handler=new Handler();

	/**
	 * 在主线程中运行
	 * @param runnable 要运行的代码
	 */
	public static void runInUIThread(Runnable runnable) {
		handler.post(runnable);
	}

	/**
	 * 主线程普通土司
	 * @param context 上下文
	 * @param msg 土司内容
     */
	public static void showToast(final Context context, final String msg){
		runInUIThread(new Runnable() {
		    @Override
		    public void run() {
				toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
				toast.setText(msg);
				toast.show();
		    }
		});
	}

	/**
	 * 主线程单例土司
	 * @param context
	 * @param msg
     */
	public static void showSingleToast(final Context context, final String msg){
		runInUIThread(new Runnable() {
			@Override
			public void run() {
				if(toast == null){
					toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
				}
				toast.setText(msg);
				toast.show();
			}
		});
	}
	
}
