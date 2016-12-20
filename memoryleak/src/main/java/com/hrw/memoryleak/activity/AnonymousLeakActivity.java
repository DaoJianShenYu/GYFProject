package com.hrw.memoryleak.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.hrw.memoryleak.R;

/**
 * Created by 高烨峰 on 2016/12/19.
 */
public class AnonymousLeakActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anonymous_leak);
        //这里有泄露
        new Thread() {
            @Override
            public void run() {
                Looper.prepare();
                new Handler();
                Looper.loop();
            }
        }.start();
    }
}
