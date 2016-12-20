package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

import com.hrw.memoryleak.MainHandler;
import com.hrw.memoryleak.global.MyApplication;
import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class HandlerActivity extends Activity {
    private TextView tv_show;
    private MainHandler handler = new MainHandler();
    private MyHandler myHandler = new MyHandler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        initView();
        Message msg = handler.obtainMessage();
        handler.sendMessage(msg);
        Message msg2 = handler.obtainMessage();
        myHandler.sendMessage(msg2);
    }

    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
        tv_show.setText("handler提成外部类防止内存泄露\nhandler写成静态内部类防止内存泄露");
    }

    static class MyHandler extends Handler{
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(MyApplication.context, "静态内部类Handler", Toast.LENGTH_SHORT).show();
        }
    }
}
