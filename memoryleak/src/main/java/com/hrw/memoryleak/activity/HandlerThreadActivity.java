package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.Html;
import android.widget.TextView;

import com.hrw.memoryleak.global.MyApplication;
import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class HandlerThreadActivity extends Activity {
    private static final int MSG_UPDATE_INFO = 0x111;
    private TextView tv_show;
    private Handler mCheckMsgHandler;
    private HandlerThread mCheckMsgThread;
    private boolean isUpdateInfo;

    /**
     * 开启后台查询线程
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        initView();
        openBackgroundCheckMsgThread();
    }


    /**
     * 得到一个子线程的handler,让其每隔3s去重新执行一次自己
     */
    private void openBackgroundCheckMsgThread() {
        mCheckMsgThread = new HandlerThread("check-message-coming");
        mCheckMsgThread.start();
        mCheckMsgHandler = new Handler(mCheckMsgThread.getLooper()){
            @Override
            public void handleMessage(Message msg) {
                checkForUpdate();
                if (isUpdateInfo) {
                    mCheckMsgHandler.sendEmptyMessageDelayed(MSG_UPDATE_INFO,3000);
                }
            }
        };
    }

    /**
     *从服务器解析数据并设置给界面
     */
    private void checkForUpdate() {
        try {
            Thread.sleep(1000);
            MyApplication.handler.post(new Runnable() {
                @Override
                public void run() {
                    String result = "实时更新中,当前大盘指数:<font color='red'>%d</font>";
                    result = String.format(result, (int) (Math.random() * 3000 + 1000));
                    tv_show.setText(Html.fromHtml(result));
                }
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 找到控件
     */
    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
    }
    /**
     * 开始查询
     */
    @Override
    protected void onResume() {
        super.onResume();
        isUpdateInfo = true;
        mCheckMsgHandler.sendEmptyMessage(MSG_UPDATE_INFO);
    }

    /**
     * 停止查询
     */
    @Override
    protected void onPause() {
        super.onPause();
        isUpdateInfo = false;
        mCheckMsgHandler.removeMessages(MSG_UPDATE_INFO);
    }

    /**
     * 关掉HandlerThread中的looper
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCheckMsgThread.quit();
    }
}
