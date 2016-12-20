package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class UIThreadWaitSonThreadActivity extends Activity {

    private TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        initView();
        MyThread myThread = new MyThread();
        myThread.start();
        String result = myThread.getResult();
        tv_show.setText("等子线程操作完成主线程才继续往下走拿到值:" + result);
    }

    private void initView() {
        tv_show = (TextView) findViewById(R.id.tv_show);
    }

    class MyThread extends Thread {

        private String result;

        @Override
        public void run() {
            synchronized (this) {
                try {
                    sleep(1000);
                    result = "success";
                    notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public String getResult() {
            synchronized (this) {
                while (isAlive() && result == null) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
            return result;
        }
    }
}
