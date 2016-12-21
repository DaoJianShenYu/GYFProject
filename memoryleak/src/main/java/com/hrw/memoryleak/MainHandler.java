package com.hrw.memoryleak;

import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.hrw.memoryleak.global.MyApplication;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class MainHandler extends Handler {


    @Override
    public void handleMessage(Message msg) {
        Toast.makeText(MyApplication.context, "单独handler类", Toast.LENGTH_SHORT).show();
    }
}
